using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;
using System.IO;

namespace MutexB
{
    class Program
    {
        static void Main(string[] args)
        {
            Thread thB = new Thread(new ThreadStart(threadB));

            thB.Start();

            System.Diagnostics.Process.Start("MutexA");

        }

        private static void threadB()
        {
            Mutex fileMutex = new Mutex(false, "MutexForTimeRecordFile");
            string path = @"D:\12345C#\线程\Mutex\TimeRecord.txt";

            for (int i = 0; i < 10; i++)
            {
                try
                {
                    fileMutex.WaitOne();
                    File.AppendAllText(path, "ThreadB:" + DateTime.Now + "\r\n");
                }
                catch (System.Threading.ThreadInterruptedException)
                {
                    Console.WriteLine("线程B被中断");
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
