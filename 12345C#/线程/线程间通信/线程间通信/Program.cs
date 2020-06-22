using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace 线程间通信
{
    class Program
    {
        //创建一个事件变量，初始值为无信号
       static   AutoResetEvent myResultEvent = new AutoResetEvent(false);
       static int number;
       static void Main(string[] args)
       {
           Thread t = Thread.CurrentThread;
           t.Name = "写线程";

           Thread thReader = new Thread(MyReaderThreadProc);
           thReader.Name = "读线程";
           thReader.Start();

           //写线程负责修改number的值，每修改一次发送一次信号
           for(int i=1;i<=10;i++)
           {
               Console.WriteLine("{0}写的值是：{1}", t.Name, i);

               //修改number的值
               number = i;

               //修改完以后发送信号
               myResultEvent.Set();
               //给读线程一点缓冲时间
               Thread.Sleep(1);
           }

           thReader.Abort();
           Console.ReadKey();

       }

       private static void MyReaderThreadProc()
       {
           while(true)
           {
               //停止往下执行，直到信号来临
               myResultEvent.WaitOne();
               //收到信号以后执行的动作
               Console.WriteLine("{0}读到的值是：{1}", Thread.CurrentThread.Name, number);
           }
       }
    }
}
