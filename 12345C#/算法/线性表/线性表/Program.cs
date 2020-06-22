using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 线性表
{
    class Program
    {
        static void Main(string[] args)
        {
            //List<string> strList = new List<string>();
            //for(int i=0;i<5;i++)
            //{
            //    strList.Add("hello" + i.ToString());
            //}

            //foreach (string str in strList)
            //    Console.WriteLine(str);

            SeqList<int> seList = new SeqList<int>();
            for (int i = 0; i < 5; i++)
                seList.Add(i);
           
            
        }
    }
}
