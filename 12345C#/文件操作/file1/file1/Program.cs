using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace file1
{
    class Program
    {
        static void Main(string[] args)
        {
            string path = "D:\\12345C#\\文件操作\\file1\\file1.txt";
            //if (File.Exists(path))
            //{
            //    string contents = File.ReadAllText(path);
            //    Console.WriteLine("文件内容：\n{0}", contents);
            //    string[] strAppend={"孤云将野鹤，","岂向人间住。","莫买沃洲山，","时人已知处。"};
            //    File.AppendAllLines(path, strAppend);
            //    Console.WriteLine("文件内容：\n{0}", contents);
            //    Console.WriteLine("文件创建时间：" + File.GetCreationTime(path)); 
            //}
            //else
            //{
            //    string contents = "故国三千里，\n深宫二十年。\n一声何满子，\n双泪落君前。\n";
            //    File.WriteAllText(path, contents);
            //}

            //字符串的三种读取方式
            byte[] buffer=File.ReadAllBytes(path);
            string str = Encoding.UTF8.GetString(buffer, 0, buffer.Length);
            //Console.WriteLine(str);

            string[] strList = File.ReadAllLines(path,Encoding.UTF8);
            //foreach(string s in strList)
            //{
            //    Console.WriteLine(s);
            //}

            string s1 = File.ReadAllText(path, Encoding.UTF8);
            Console.WriteLine(s1);

            Console.ReadKey();
        }
    }
}
