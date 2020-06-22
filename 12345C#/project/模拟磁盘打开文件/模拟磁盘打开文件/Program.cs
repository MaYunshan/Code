using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using System.Diagnostics;

namespace 模拟磁盘打开文件
{
    class Program
    {
        static void Main(string[] args)
        {
            while(true)
            {
                Console.WriteLine("请输入要进入的磁盘:");
                string path = Console.ReadLine();
                Console.WriteLine("请输入要打开的文件路径:");
                string fileName = Console.ReadLine();

                FileFather ff = GetExtention(fileName, path + fileName);
                ff.OpenFile();
            }
        }

        //根据扩展名去建立对应的文件对象，并且返回一个父类对象
        public static FileFather GetExtention(string fileName,string fullPath)
        {
            FileFather ff = null;
            string fileType = Path.GetExtension(fileName);
            switch(fileType)
            {
                case ".txt": ff = new TxtClass(fullPath);
                    break;
                case ".wmv": ff = new WmvClass(fullPath);
                    break;
                case ".jpg": ff = new JpgClass(fullPath);
                    break;
            }
            return ff;
        }
    }

    public abstract class FileFather
    {
        public string FullPath
        {
            get;
            set;
        }

        public FileFather(string fullPath)
        {
            this.FullPath = fullPath;
        }
        public abstract void OpenFile();
    }

    public class TxtClass:FileFather
    {
        public TxtClass(string fullPath)
            : base(fullPath)
        {

        }
        public override void OpenFile()
        {
            ProcessStartInfo psi = new ProcessStartInfo(this.FullPath);
            Process ps = new Process();
            ps.StartInfo = psi;
            ps.Start();
        }
    }

    public class WmvClass : FileFather
    {
        public WmvClass(string fullPath)
            : base(fullPath)
        {

        }
        public override void OpenFile()
        {
            ProcessStartInfo psi = new ProcessStartInfo(this.FullPath);
            Process ps = new Process();
            ps.StartInfo = psi;
            ps.Start();
        }
    }

    public class JpgClass : FileFather
    {
        public JpgClass(string fullPath)
            : base(fullPath)
        {

        }
        public override void OpenFile()
        {
            ProcessStartInfo psi = new ProcessStartInfo(this.FullPath);
            Process ps = new Process();
            ps.StartInfo = psi;
            ps.Start();
        }
    }

    
}
