using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 深入委托
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
            Del d1 = RunTime;    //通过委托类型定义了一个变量指向runtime，相当于函数指针变量
            d1("aaaaaa");        
            Console.WriteLine("******************************************");
            d1("bbbbbb");
            Console.WriteLine("******************************************");



            MethodWithCallBack("aaa", "bbb", d1);

            //多播委托,,可以让一个委托调用一系列方法  
            Del d3 = RunTime;
            d3 += writeStr;
            d3("123456");

            Console.ReadKey();
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
