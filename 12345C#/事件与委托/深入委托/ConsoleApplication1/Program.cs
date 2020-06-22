using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{

 /****************************************************************************************
 * 声明一个函数指针类型
 * typedef  void  (*myPTypeFunc)(int  a,int  b)  ;   //声明了⼀一个指针的数据类型
 * 定义一个函数指针
 * myPTypeFunc  fp  =  NULL;   //通过   函数指针类型  定义了  ⼀一个函数指针  ,
 **************************************************************************************/


    //声明一种类型的函数委托 ，，，相当于是一种函数指针
    delegate void Del(string msg);

    class Program
    {
        static void Main(string[] args)
        {
            Del d4 = delegate(string msg)
            {
                Console.WriteLine(msg);
            };

            d4("cccccccccccc");
        }

        public static void RunTime(string ms)
        {
            Console.WriteLine(ms);
        }

        public static void writeStr(string ms)
        {
            Console.WriteLine(ms);
        }

        #region
        public static void MethodWithCallBack(string str1, string str2, Del d2)
        {
            StringBuilder say = new StringBuilder();
            say.Append("有人喜欢你，他的信息如下\n");
            say.Append(str1);
            say.Append("\n他还送上");
            say.Append(str2);
            say.Append("作为定情信物\n");
            d2(say.ToString());
        }
        #endregion
    }
}
