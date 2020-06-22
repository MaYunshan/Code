
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace 读取工资并且翻倍
{
    class Program
    {
        
        static void Main(string[] args)
        {
            string path = @"D:\12345C#\文件操作\Directory\salary.txt";

            string[] strLine = File.ReadAllLines(path,Encoding.Default);
            Console.WriteLine(strLine[0]);
            for (int i = 0; i < strLine.Length;i++ )
            {
                string[] str = strLine[i].Split(new char[] { '：' }, StringSplitOptions.RemoveEmptyEntries);
                int salary = Convert.ToInt32(str[1]) * 2;
                strLine[i] = str[0] + "：" + salary.ToString();
            }

            string direcoty = Path.GetDirectoryName(path);
            string path2 = direcoty + @"\s.txt";
            File.Copy(path, path2);
            File.WriteAllLines(path2, strLine);
        }
    }
}
