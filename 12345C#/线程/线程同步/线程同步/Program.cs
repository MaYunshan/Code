using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace 线程同步
{
    class Program
    {
        private static long numberOfUser = 0;     //用于互锁的增量值
        private static char buffer;
        static void Main(string[] args)
        {

            Thread thWriter = new Thread(delegate()
                {
                    string sentence = "红豆生南国，春来发几枝。愿君多采撷，此物最相思。";

                    for(int i=0;i<24;i++)
                    {
                        //当numberOfUser为1的时候，说明读线程正在工作，写线程在这里循环，直到读线程完了以后。写线程开始，互锁线程
                        while (Interlocked.Read(ref numberOfUser) == 1)   
                        { Thread.Sleep(10); }
                        buffer = sentence[i];
                        Interlocked.Increment(ref numberOfUser);
                    }
                });

            Thread thReader = new Thread(delegate()
                {
                    for (int i = 0; i < 24; i++)
                    {
                        while (Interlocked.Read(ref numberOfUser) == 0)
                        { Thread.Sleep(10); }
                        char ch=buffer;
                        Console.Write(ch);
                        Interlocked.Decrement(ref numberOfUser);
                    }
                });

            thWriter.Start();
            thReader.Start();
        }
    }
}
