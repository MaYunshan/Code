using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 扩展方法
{
    class Program
    {
        static void Main(string[] args)
        {
            #region 自己写的扩展方法

            /*
             * 扩展方法只是看起来像是某个对象的方法，但实际上根本不是，其实就是调用了一个静态方法
             * 扩展方法无法访问到类内部的私有成员
             */
            Person p = new Person();
            p.Name = "mys";
            p.SayHello();
            #endregion

            #region
            string s = "asdfghjkl";
            Console.WriteLine( s.GetCount());
            #endregion
        }
    }

    public class Person
    {
        public string Name
        {
            set;
            get;
        }
    }

    //1.扩展方法-----先定义一个静态类
    public static class PersonExt
    {
        public static void SayHello(this Person p)
        {
            Console.WriteLine(p.Name);
            Console.WriteLine("大家好！");
        }
    }


    //string类的扩展方法
    public static class stringExt
    {
        public static int GetCount(this string str)
        {
            return str.Length;
        }
    }
}
