using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace 委托处理文件
{
   
    public delegate void MyFileProcess(FileStream fileStream);
   class Program
    {
        static void Main(string[] args)
        {
            string filename = @"D:\12345C#\文件操作\文件流的异常\2.data";
            MyFileProcess fileP = DoWrite;
            
            UniversalFile(filename, fileP);


        }

       //这个函数用来调用回调函数，还有对文件处理发生异常的操作
        public static void UniversalFile(string path,MyFileProcess dealFile)
        {
            FileStream fileStream1 = new FileStream(path, FileMode.OpenOrCreate, FileAccess.ReadWrite);
            try
            {
                dealFile(fileStream1);
            }
            catch(Exception e)
            {
                Console.WriteLine(e.Message);
            }
            finally
            {
                if (fileStream1 != null)
                    fileStream1.Close();
            }
        }
        
       //用来存取数据的回调函数
        public static void DoWrite(FileStream fileStream)
        {
            byte[] datas = { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };
            fileStream.Write(datas, 0, datas.Length);
        }

       //用来读数据的回调函数
       public static void DoRead(FileStream fileStream)
        {
            byte[] datas = new byte[fileStream.Length];
            fileStream.Read(datas, 0, datas.Length);
        }
    }
}
