using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace 文件流的操作
{
    class Program
    {
        static void Main(string[] args)
        {
            string filename = @"D:\12345C#\文件操作\文件流的操作\1.data";
            if(!File.Exists(filename))
            {
                FileInfo myFile = new FileInfo(filename);
                FileStream myStream = myFile.OpenWrite();  //OpenWrite的返回值是filestream的对象
                byte[] datas = { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };
                myStream.Write(datas, 0, datas.Length);
                Console.WriteLine("文件已经写入");
                myStream.Close();
            }
            else
            {
                FileStream myStream = new FileStream(filename, FileMode.Open, FileAccess.ReadWrite, FileShare.ReadWrite);
                byte[] data = new byte[myStream.Length];
                myStream.Read(data, 0,data.Length);
                foreach(byte by in data)
                    Console.Write(by+" ");
                Console.WriteLine();
                myStream.Close();
            }
        }
    }
}
