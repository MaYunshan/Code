using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace 死锁
{
    

    class Program
    {
        private static object fork = new object();
        private static object knife = new object();
        static void Main(string[] args)
        {
            Thread thGirl = new Thread(Girl);
            thGirl.Name = "女孩";

            Thread thBoy = new Thread(new ThreadStart(Boy));
            thBoy.Name = "男孩";

            thGirl.Start();
            thBoy.Start();
        }

        private static void Boy()
        {
            //
            Thread.Sleep(5);
            lock (knife)
            {
                Console.WriteLine("\n你更美");
                GetKnife();
                lock(fork)
                {
                    GetFork();
                    Eat();
                    Console.WriteLine("男孩放下叉子");
                    Monitor.Pulse(fork);
                }
                Console.WriteLine("男孩放下刀子");
                Monitor.Pulse(knife);
            }
        }

        private static void Girl()
        {
            Console.WriteLine("今晚的月色好美");

            lock(knife)
            {
                GetKnife();

                lock(fork)
                {
                    GetFork();
                    Eat();

                    Console.WriteLine("女孩放下叉子");
                    Monitor.Pulse(fork);
                }
                Console.WriteLine("女孩放下刀子");
                Monitor.Pulse(knife);
            }
        }

        private static void Eat()
        {
            Console.WriteLine(Thread.CurrentThread.Name+"开始吃");
        }

        private static void GetFork()
        {
            Console.WriteLine(Thread.CurrentThread.Name + "拿起叉子");
        }

        private static void GetKnife()
        {
            Console.WriteLine(Thread.CurrentThread.Name + "拿起刀子");
        }
    }
}
