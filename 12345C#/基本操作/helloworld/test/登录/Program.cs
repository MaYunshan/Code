using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace 登录
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("欢迎进入登录系统\n");
            Console.WriteLine("请输入用户名：");
            string name = Console.ReadLine();
            Console.WriteLine("当前登录用户为：" + name);
    
        }
    }
}
