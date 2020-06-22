using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace 插入线程
{
    class Program
    {
        static void Main(string[] args)
        {
            Thread threadA = new Thread(delegate()
            {
                for (int i = 0; i < 1000000000; i++)
                {
                    if (i % 10000000 == 0)
                        Console.Write("A ");
                }
            });

            Thread threadB = new Thread(delegate()
            {
                for (int i = 0; i < 1000000000; i++)
                {
                    if (i % 10000000 == 0)
                        Console.Write("B ");
                }

                threadA.Join();

                for (int i = 0; i < 1000000000; i++)
                {
                    if (i % 10000000 == 0)
                        Console.Write("M ");
                }
            });

            threadA.Start();
            threadB.Start();
        }
    }
}
