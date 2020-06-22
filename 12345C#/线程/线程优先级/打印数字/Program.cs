using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace 打印数字
{
    class Program
    {
        static void Main(string[] args)
        {
            PriorityTest work=new PriorityTest();
            Thread thA = new Thread(new ThreadStart(work.ThreadMethod));
            Thread thB = new Thread(new ThreadStart(work.ThreadMethod));

            thA.Name = "线程A";
            thB.Name = "线程B";

            thA.Priority = ThreadPriority.Highest;
            thB.Priority = ThreadPriority.Lowest;

            thA.Start();
            thB.Start();

            Thread.Sleep(1000);
            work.bLoopSwitch = false;
        }
    }

    class PriorityTest
    {
        private bool LoopSwitch;

        public bool bLoopSwitch
        {
            set { LoopSwitch = value; }
        }

        public PriorityTest()
        {
            bLoopSwitch = true;
        }

        public void ThreadMethod()
        {
            long threadCount = 0;

            while(LoopSwitch)
            {
                threadCount++;
            }
            Console.WriteLine("{0},优先级：{1}" + ":{2}", Thread.CurrentThread.Name,
                                                   Thread.CurrentThread.Priority.ToString(),
                                                   threadCount.ToString());
        }
    }
}
