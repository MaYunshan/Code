using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 字符串操作
{
    class Program
    {
        static void Main(string[] args)
        {
            string s1 = "Hello World!";
            string s2 = s1;          //s1跟s2指向同一块内存区域
            Console.WriteLine("{0}\n{1}", s1, s2);
            s1 = "Hello";            //字符串无法修改，重新为s1开辟一段内存，重新赋值
            Console.WriteLine("{0}\n{1}", s1, s2);
            Console.WriteLine(s1[0]);
            // s1[0] = 'h';       //这样的操作是错误的


            StringBuilder s3=new StringBuilder(s1);
            s3[0] = 'h';
            Console.WriteLine(s3);
        }
    }
}
