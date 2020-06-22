using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 链表
{
    class Program
    {
        static void Main(string[] args)
        {
            LinkList1<int> lList=new LinkList1<int>();
            lList.Add(0);
            lList.Add(1);
            lList.Add(2);
            lList.Add(3);
            lList.Add(4);
            //lList.Add(6);
            //lList.Add(7);
            //lList.Add(8);

            for (int i = 0; i < lList.GetLength(); i++)
                Console.Write("{0} ", lList[i]);
            Console.WriteLine();

                lList.Delete(4);
                for (int i = 0; i < lList.GetLength(); i++)
                    Console.Write("{0} ", lList[i]);
                Console.WriteLine();

                lList.Delete(3);
                for (int i = 0; i < lList.GetLength(); i++)
                    Console.Write("{0} ", lList[i]);
                Console.WriteLine();

                lList.Delete(2);
                for (int i = 0; i < lList.GetLength(); i++)
                    Console.Write("{0} ", lList[i]);
                Console.WriteLine();
                lList.Delete(1);
                for (int i = 0; i < lList.GetLength(); i++)
                    Console.Write("{0} ", lList[i]);
                Console.WriteLine();
                lList.Delete(0);
                Console.WriteLine(lList.IsEmpty().ToString());

                lList.Insert(0, 0);
                lList.Insert(1, 1);
                lList.Insert(2, 2);
                lList.Insert(3, 3);
                for (int i = 0; i < lList.GetLength(); i++)
                    Console.Write("{0} ", lList[i]);
                Console.WriteLine();

                lList.Insert(4, 0);
                for (int i = 0; i < lList.GetLength(); i++)
                    Console.Write("{0} ", lList[i]);
                Console.WriteLine();
                //lList.Insert(9, 9);

        }
    }
}
