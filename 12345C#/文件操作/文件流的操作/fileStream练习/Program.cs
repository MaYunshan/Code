using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace fileStream练习
{
    class Program
    {
        static void Main(string[] args)
        {
            string path = @"D:\12345C#\文件操作\文件流的操作\1.txt";
            //using (FileStream fread = new FileStream(path,FileMode.OpenOrCreate,FileAccess.Read))
            //{
            //    byte[] buffer = new byte[1024 * 1024 * 5];
            //    int nRead=fread.Read(buffer, 0, buffer.Length);
            //    string str = Encoding.Default.GetString(buffer,0,nRead);
            //    Console.WriteLine(str);
            //}

            //using(FileStream fread=new FileStream(path,FileMode.OpenOrCreate,FileAccess.Read))
            //{
            //    using(StreamReader sReader=new StreamReader(fread,Encoding.Default))
            //    {
            //       while(!sReader.EndOfStream)
            //       {
            //           string str = sReader.ReadLine();
            //           Console.WriteLine(str);
            //       }
            //    }
            //}

            Console.ReadKey();
        }
    }
}
