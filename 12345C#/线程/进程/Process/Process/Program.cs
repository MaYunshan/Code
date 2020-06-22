using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Diagnostics;

namespace 进程Process
{
    class Program
    {
        static void Main(string[] args)
        {

            //获得当前正在运行的所有进程
            //Process[] procs = Process.GetProcesses();
            //foreach(var item in procs)
            //{
            //    Console.WriteLine(item.ToString());
            //}

            //打开一个进程
            //Process.Start("calc");
            //Process.Start("SnippingTool");

            ProcessStartInfo psi = new ProcessStartInfo(@"C:\Users\dell\Desktop\1.txt");

            Process p = new Process();
            p.StartInfo = psi;
            p.Start();
        }
    }
}
