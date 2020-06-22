using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

//namespace _1_1一亿
//{
//    class Program
//    {
//        private static object obj = new object();   //monitor类需要object类的对象，类似于一个资源的标识符。那个线程拥有它，就可以操作资源
//        static long s = 0;
//        static void Main(string[] args)
//        {

//            long[] para1 = new long[2] { 1, 50000000 };
//            long[] para2 = new long[2] { 50000000, 100000000 };
//            Thread thAdd1 = new Thread(new ParameterizedThreadStart(method));
//            Thread thAdd2 = new Thread(new ParameterizedThreadStart(method));

//            DateTime t1 = DateTime.Now;
//            thAdd1.Start(para1);
//            thAdd2.Start(para2);
//            thAdd1.Join();
//            thAdd2.Join();

//            DateTime t2 = DateTime.Now;

//            string diff = (t2 - t1).ToString();
//            Console.WriteLine(diff);
//            Console.WriteLine(s);


//        }

//        static private void method(object o)
//        {
//            //此处对传进来的参数进行处理
//            long[] p = (long[])o;
//            method(p[0], p[1]);
//        }

//        static private void method(long begin, long end)
//        {
//            long sum = 0;
//            for (long i = begin; i < end; i++)
//            {
//                sum += i;
//            }
//            lock (obj)
//            {
//                s += sum;
//                Console.WriteLine("{0}--{1}", sum, s);
//            }
//        }
//    }
//}


namespace _1_1一亿
{
    class Program
    {
        static long sum = 0, sum1 = 0, sum2 = 0;
        static void Main(string[] args)
        {

            Thread thAdd1 = new Thread(new ThreadStart(Add1));
            Thread thAdd2 = new Thread(new ThreadStart(Add2));

            DateTime t1 = DateTime.Now;
            thAdd1.Start();
            thAdd2.Start();
            thAdd1.Join();
            thAdd2.Join();
            sum = sum1 + sum2;
            DateTime t2 = DateTime.Now;

            string diff = (t2 - t1).ToString();
            Console.WriteLine(diff);
            Console.WriteLine("{0}--{1}--{2}", sum1, sum2, sum);

        }

        private static void Add1()
        {
            for (long i = 0; i < 50000000; i++)
            {
                sum1 += i;
            }
        }

        private static void Add2()
        {
            for (long i = 50000000; i < 100000000; i++)
            {
                sum2 += i;
            }
        }
    }
}
