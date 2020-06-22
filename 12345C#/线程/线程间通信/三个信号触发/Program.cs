using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace 三个信号触发
{
    class Program
    {
        static void Main(string[] args)
        {
            Person p = new Person();

            Thread th1 = new Thread(p.GetCar);
            th1.Start();

            Thread th2 = new Thread(p.GetHome);
            th2.Start();

            Thread th3 = new Thread(p.GetWife);
            th3.Start();

            AutoResetEvent.WaitAll(p.autoEvents);
            p.ShowHappiness();

        }
    }

    
    class Person
    {
        //建立一个事件通知数组
        public AutoResetEvent[] autoEvents;

        IAsyncResult
        public Person()
        {
            autoEvents = new AutoResetEvent[]
             {
                 new AutoResetEvent(false),
                 new AutoResetEvent(false),
                 new AutoResetEvent(false)
             };
        }

        public void GetCar()
        {
            Console.WriteLine("捡到车子");
            //发送捡到车子信号
            autoEvents[0].Set();
        }

        public void GetHome()
        {
            Console.WriteLine("得到房子");
            //发送得到房子信号
            autoEvents[1].Set();
        }

        public void GetWife()
        {
            Console.WriteLine("得到老婆");
            //发送得到老婆信号
            autoEvents[2].Set();
        }

        public void ShowHappiness()
        {
            Console.WriteLine("人生如此美好！");
        }
    }
}
