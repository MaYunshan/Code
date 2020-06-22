using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace 文件流的异常
{
    class Program
    {
        static void Main(string[] args)
        {
            string filename = @"D:\12345C#\文件操作\文件流的异常\1.data";
            FileStream myStream = null;
            FileStream myStream1 = null;
            try
            {
                FileInfo myFile = new FileInfo(filename);
                myStream = myFile.OpenWrite();  //OpenWrite的返回值是filestream的对象
                byte[] datas = { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };
                myStream.Write(datas, 0, datas.Length);
                Console.WriteLine("文件已经写入");
                myStream.Close();

                myStream1 = new FileStream(filename, FileMode.Open, FileAccess.ReadWrite, FileShare.ReadWrite);
                byte[] data = new byte[myStream1.Length];
                myStream1.Read(data, 0, data.Length);
                foreach (byte by in data)
                    Console.Write(by + " ");
                Console.WriteLine();
                myStream1.Close();
            }
            catch(Exception e)
            {
                Console.WriteLine(e.Message);
            }
            finally
            {
                if (myStream != null)
                    myStream.Close();
                if (myStream1 != null)
                    myStream1.Close();
            }
            Console.WriteLine();
        }
    }
}
