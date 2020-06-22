using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;
using System.Runtime.InteropServices;

namespace 单例模式
{
    class Program
    {
        static void Main(string[] args)
        {
            //Singleton sin1 = Singleton.GetInstance();
            //if (sin1 == null)
            //    Console.WriteLine(1123);
            //Singleton sin2 = Singleton.GetInstance();
            //if (sin2 == null)
            //    Console.WriteLine(123);


            Thread th1 = new Thread(new ThreadStart(Sin1));
            th1.Start();
            //Thread.Sleep(100);
            Thread th2 = new Thread(new ThreadStart(Sin1));
            //Thread.Sleep(100);
            th2.Start();
            Thread th3 = new Thread(new ThreadStart(Sin1));
            //Thread.Sleep(100);
            th3.Start();
            Thread th4 = new Thread(new ThreadStart(Sin1));
            //Thread.Sleep(100);
            th4.Start();
            Thread th5 = new Thread(new ThreadStart(Sin1));
            //Thread.Sleep(100);
            th5.Start();
        }

        private static void Sin1()
        {
            Singleton sin2 = Singleton.GetInstance();

           
            //GCHandle hander = GCHandle.Alloc(sin2);
            //var pin = GCHandle.ToIntPtr(hander);
            //Console.WriteLine(pin);
        }
      


    }
    public class Singleton
    {
        private static object obj = new object();
        private static Singleton instance;
        private static int i = 0;
        private Singleton()   //私有函数，防止实例
        {

        }
        public static Singleton GetInstance()
        {
            //if (instance == null)
            //{
            //    instance = new Singleton();
            //    Console.WriteLine(i++);

            //}
            //return instance;

            if (instance == null)
            {
                lock (obj)      //通过Lock关键字实现同步
                {
                    if (instance == null)
                    {
                        instance = new Singleton();
                        Console.WriteLine(i++);
                    }
                }
            }
            return instance;
        }
    }
}
