using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace 线程同步Lock
{
    //独占锁，谁拥有锁，谁就可以操作资源，操作完以后，要解除锁的占用，还要向别的线程转移锁
    //但是这样也会使得效率降低 
    class Program
    {
        private static object lockBuffer = new object();   //monitor类需要object类的对象，类似于一个资源的标识符。那个线程拥有它，就可以操作资源
        private static char buffer;
        static void Main(string[] args)
        {
            Thread thWriter = new Thread(delegate()
            {
                string sentence = "红豆生南国，春来发几枝。愿君多采撷，此物最相思。";

                for (int i = 0; i < 24; i++)
                {
                    //lock语句是用monitor类来实现的，它等效于try/finally语句块
                    lock(lockBuffer)
                    {
                        buffer = sentence[i];
                        Monitor.Pulse(lockBuffer);      //写线程操作完资源以后，唤醒资源上的读线程
                        Monitor.Wait(lockBuffer);       //释放资源，并且禁止本线程操作资源，直到它被再次唤醒
                    }
                
                }
            });

            Thread thReader = new Thread(delegate()
            {
                for (int i = 0; i < 24; i++)
                {
                    lock(lockBuffer)
                    {
                        char ch = buffer;
                        Console.Write(ch);
                        Monitor.Pulse(lockBuffer);
                        Monitor.Wait(lockBuffer);
                    }
                }
            });

            thWriter.Start();
            thReader.Start();
        }
    }
}
