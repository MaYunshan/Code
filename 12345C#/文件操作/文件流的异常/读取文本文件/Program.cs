using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace 读取文本文件
{
    class Program
    {
        static void Main(string[] args)
        {
            StreamReader streamRead = null;
            StreamWriter streamWrite = null;

            string path = @"D:\12345C#\文件操作\文件流的异常\3.txt";
            try
            {
                if(!File.Exists(path))
                {
                    FileInfo myInfo = new FileInfo(path);
                    streamWrite = myInfo.CreateText();
                    string context = "怀君属秋夜，\n散步咏凉天。\n空山松子落，\n幽人应未眠。\n";
                    streamWrite.Write(context);
                }
                else
                {
                    FileInfo myInfo = new FileInfo(path);
                    streamRead = myInfo.OpenText();

                    //char[] str = new char[100];
                    //streamRead.Read(str,0,50);

                    //string str = streamRead.ReadToEnd();
                    //Console.WriteLine(str);

                    string str1 = streamRead.ReadLine();
                    Console.WriteLine(str1);
                    Console.WriteLine(streamRead.CurrentEncoding);
                }
            }
            catch(Exception e)
            {
                Console.WriteLine(e.Message);
            }
            finally
            {
                if (streamRead != null)
                    streamRead.Close();
                if (streamWrite != null)
                    streamWrite.Close();
                Console.ReadKey();
            }
        }
    }
}
