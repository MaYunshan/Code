using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
    
namespace 环境类
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("当前程序所在目录：" + Environment.CurrentDirectory);
            Console.WriteLine("获取本地计算机的名称：" + Environment.MachineName);
            Console.WriteLine("获取当前环境的换行字符串：" + Environment.NewLine);
            Console.WriteLine("获取当前系统版本号：" + Environment.OSVersion);
            Console.WriteLine("获取当前计算机上的处理器数：" + Environment.ProcessorCount);
            Console.WriteLine("获取与当前用户相关的网络域名：" + Environment.UserDomainName);
            Console.WriteLine("返回当前进程的命令行参数：" + Environment.GetCommandLineArgs());
            foreach (string str in Environment.GetCommandLineArgs())
                Console.WriteLine(str);
            Console.WriteLine("返回计算机中所有逻辑驱动器的名称：" + Environment.GetLogicalDrives());
            foreach (string str in Environment.GetLogicalDrives())
                Console.WriteLine(str);


        }
    }
}
