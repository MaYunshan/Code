using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace 线程同步打印数字
{
    class Program
    {
        static void Main(string[] args)
        {
            Thread[] ths = new Thread[10];

            for(int i=0;i<10;i++)
            {
                ths[i] = new Thread(new ThreadStart(PrintNumber));
                ths[i].Name = i.ToString() + "号线程";
            }

            foreach(Thread th in ths)
            {
                th.Start();
            }

            Console.WriteLine();
        }

        private static void PrintNumber()
        {
            Console.WriteLine("{0}号线程开始打印数字",Thread.CurrentThread.Name);

            for(int i=0;i<10;i++)
            {
                Random r = new Random();
                //Thread.Sleep(20);
                Thread.Sleep(2000 * r.Next(5));

                Console.WriteLine("{0}-{1}", i, Thread.CurrentThread.Name);
            }
            


        }
    }
}
