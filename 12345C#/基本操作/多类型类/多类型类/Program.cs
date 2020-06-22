using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 多类型类
{
    class Program
    {
        static void Main(string[] args)
        {
            MYS.Store store = new MYS.Store(5);
            store.Add(33);
            store.Add(3.14);
            store.Add("asd");
            store.Add(new MYS.Store(5));

            foreach(object item in store.item)
            {
                Console.WriteLine(item);
            }
            Console.ReadLine();
        }
    }

    namespace MYS
    {
        class Store
        {
            public Object[] item;
            private int nCount;
            public Store(int size)
            {
                item = new Object[size];
                nCount = 0;
            }
            public void Add(Object obj)
            {
                if (nCount < item.Length)
                {
                    item[nCount] = obj;
                    nCount++;
                }
                else
                {
                    Console.WriteLine("仓库已满");
                }
            }
        }
    }
}
