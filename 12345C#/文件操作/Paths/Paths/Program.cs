using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace Paths
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("操作系统中的路径分隔符：" + Path.DirectorySeparatorChar);
            Console.WriteLine("操作系统中环境变量的分隔符：" + Path.PathSeparator);
            Console.WriteLine("操作系统中的卷分隔符：" + Path.VolumeSeparatorChar);

            string path = @"D:\12345C#\文件操作\hello.txt";

            Console.WriteLine("指定路径中的文件名：" + Path.GetFileName(path));
            Console.WriteLine("指定路径中的主文件名：" + Path.GetFileNameWithoutExtension(path));
            Console.WriteLine("指定路径中的扩展名：" + Path.GetExtension(path));
            //Console.WriteLine("：" + Path);
            //Console.WriteLine("：" + Path);  

            Console.ReadKey();
        }
    }
}
