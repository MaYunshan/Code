using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace 线程池
{
    //一个应用程序只能有一个线程池\

    //线程池是一种多线程处理形式，处理过程中将任务添加到队列，然后在创建线程后自动启动这些任务。
    //线程池线程都是后台线程。每个线程都使用默认的堆栈大小，以默认的优先级运行，并处于多线程单元中。
    //如果某个线程在托管代码中空闲（如正在等待某个事件）,
    //则线程池将插入另一个辅助线程来使所有处理器保持繁忙。如果所有线程池线程都始终保持繁忙，
    //但队列中包含挂起的工作，则线程池将在一段时间后创建另一个辅助线程但线程的数目永远不会超过最大值。
    //超过最大值的线程可以排队，但他们要等到其他线程完成后才启动。


    //public delegate void WaitCallBack(Object dataForFunction)
    class Program
    {
        static int finishedThreadCount = 0;      //用来记录任务被执行的次数
        static int[] result = new int[10];
        static void Main(string[] args)
        {
            for(int i=0;i<=9;i++)
            {
                //向线程池中添加十个任务，分别求0到9的阶乘
                ThreadPool.QueueUserWorkItem(new WaitCallback(WorkFunction), i);
            }
            int k=0;
            int j=0;
           ThreadPool.GetAvailableThreads(out k, out j);
           Console.WriteLine("{0}——{1}", k, j);
            while (finishedThreadCount < 9) ;
            for(int i=0;i<=9;i++)
            {
                Console.WriteLine("线程{0}:{0}!={1}", i, result[i]);
            }
        }

        public static void WorkFunction(object n)
        {
            int fac = 1;
            for (int i = 1; i <= (int)n; i++)
                fac *= i;
            result[(int)n] = fac;
            finishedThreadCount++;
            Console.WriteLine(Thread.CurrentThread.ManagedThreadId);
        }
    }
}
