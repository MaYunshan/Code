using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace 文件夹
{
    class Program
    {
        static void Main(string[] args)
        {

           //获取当前应用程序的目录
            //string path1 = Directory.GetCurrentDirectory();
            //Console.WriteLine(path1);

            try
            {
                string path = @"D:\12345C#\文件操作\Directory\Directory"; 
                if (Directory.Exists(path))
                {
                    string[] dir = Directory.GetDirectories(path);
                    foreach (string str in dir)
                       Console.WriteLine(str);

                    string[] files = Directory.GetFiles(path);
                    foreach (string str in files)
                        Console.WriteLine(str);
                }
              }
            catch(Exception e)
            {
                Console.WriteLine(e.Message);
            }
            Console.ReadKey();
        }
    }
}
