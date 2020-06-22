using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

//FileStream类可以对任意类型的文件进行读取操作，而且我们也可以按照需要指定每一次读取字节长度
//StreamWriter/SteamReader的特点是，它只能对文本文件进行读写操作，可以一行一行的写入和读取。

namespace fileStream和stream
{
    class Program
    {
        static void Main(string[] args)
        {
            string path = @"D:\12345C#\文件操作\文件流的异常\3.txt";
            string path1 = @"D:\12345C#\文件操作\文件流的异常\3b.txt";
            using(FileStream fread=new FileStream(path,FileMode.Open))
            {
                using(FileStream fwrite=new FileStream(path1,FileMode.Create))
                {
                    int ncount = 0;
                    byte[] bb=new byte[10];
                    while (true)
                    {
                        ncount = fread.Read(bb, 0, bb.Length);
                        //Console.WriteLine(bb);
                        if (ncount == 0)
                            break;
                        fwrite.Write(bb, 0, ncount);
                    }
                    Console.WriteLine("成功转入！");
                }
            }
        }
    }
}
