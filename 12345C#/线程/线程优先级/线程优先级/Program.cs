using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace 线程优先级
{
    class Program
    {
        static void Main(string[] args)
        {
            Thread threadA = new Thread(new ThreadStart(PrintA));

            Thread threadB=new Thread(delegate()
            {
                for(int i=0;i<1000000000;i++)
                {
                    if (i % 10000000 == 0)
                        Console.Write("B ");
                }
            });



            threadA.Priority = ThreadPriority.Highest;
            threadB.Priority = ThreadPriority.Lowest;
  
            threadA.Start();
            //threadA.Join();
            threadB.Start();


           

            //主线程
            for (int i = 0; i < 1000000000; i++)
            {
                if (i % 10000000 == 0)
                    Console.Write("M ");
            }
        }

        private static void PrintA()
        {
            for (int i = 0; i < 1000000000; i++)
            {
                if (i % 10000000 == 0)
                    Console.Write("A ");
            }
        }
    }
}
