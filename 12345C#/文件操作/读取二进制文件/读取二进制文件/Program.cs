using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace 读取二进制文件
{
    class Program
    {

        static void Main(string[] args)
        {
            string path = @"D:\12345C#\文件操作\文件流的异常\二进制.txt";
            FileStream fileStream = null;
            try
            {
                fileStream = File.Create(path);
                
                //在流的结束位置，偏移为0，从末尾开始添加
                fileStream.Seek(0, SeekOrigin.End);

                BinaryWriter bw = new BinaryWriter(fileStream);
                DateTime dt = DateTime.Now;
                bw.Write(dt.Year);
                bw.Write(dt.Month);
                bw.Write(dt.Day);
                bw.Write(dt.Hour);
                bw.Write(dt.Minute);
                bw.Write(dt.Second);
                //在流的开始位置，偏移为0，即从头开始
                fileStream.Seek(0, SeekOrigin.Begin);

                BinaryReader br = new BinaryReader(fileStream);
                int year = br.ReadInt32();
                int month = br.ReadInt32();
                int day = br.ReadInt32();
                int hour = br.ReadInt32();
                int minute = br.ReadInt32();
                int second = br.ReadInt32();

                Console.WriteLine("{0}-{1}-{2}:{3}:{4}:{5}", year, month, day, hour, minute, second);
            }
            catch(Exception e)
            {
                Console.WriteLine(e.Message);
            }
            finally
            {
                if (fileStream != null)
                    fileStream.Close();
            }
        }
    }
}
