using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;
using System.IO;

//互斥锁（Mutex）

//互斥锁是一个互斥的同步对象，意味着同一时间有且仅有一个线程可以获取它。

//互斥锁可适用于一个共享资源每次只能被一个线程访问的情况

namespace MutexA
{
    class Program
    {
        static void Main(string[] args)
        {
            Thread thA = new Thread(new ThreadStart(threadA));

            thA.Start();

            
        }

        private static void threadA()
        {
            Mutex fileMutex = new Mutex(false, "MutexForTimeRecordFile");
            string path = @"D:\12345C#\线程\Mutex\TimeRecord.txt";

            for(int i=0;i<10;i++)
            {
                try
                {
                    fileMutex.WaitOne();
                    File.AppendAllText(path, "ThreadA:" + DateTime.Now + "\r\n");
                }
                catch(System.Threading.ThreadInterruptedException)
                {
                    Console.WriteLine("线程A被中断");
                }
                finally
                {
                    fileMutex.ReleaseMutex();
                    Thread.Sleep(1000);
                }
            }
        }
    }
}
