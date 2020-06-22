 using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 超市收银系统
{
    class ProductHouse
    {
        //存储货物的仓库
        //集合的集合。外层集合相当于货架，子集合相当于各种货物
        List<List<BaseProduct>> list = new List<List<BaseProduct>>();

        /// <summary>
        /// 在创建仓库的时候同时创建货架
        /// list[0] 存储香蕉
        /// list[1] 存储手机
        /// list[2] 存储电脑
        /// </summary>
        public ProductHouse()
        {
            list.Add(new List<BaseProduct>());
            list.Add(new List<BaseProduct>());
            list.Add(new List<BaseProduct>());
        }

        public void Stock(string productType,int count)
        {
            for(int i=0;i<count;i++)
            {
                switch(productType)
                {
                    case "Banana": list[0].Add(new Banana(1000, "香蕉", Guid.NewGuid().ToString()));
                        break;
                    case "Computer": list[1].Add(new Computer(1000, "电脑", Guid.NewGuid().ToString()));
                        break;
                    case "Samsung": list[2].Add(new Computer(1000, "手机", Guid.NewGuid().ToString()));
                        break;
                }
            }
        }

        public BaseProduct[] Fetch (string productType,int count)
        {
            BaseProduct[] prod = new BaseProduct[count];

            for (int i = 0; i < count; i++)
            {
                switch (productType)
                {
                    case "Banana":
                        prod[i] = list[0][0];
                        list[0].RemoveAt(0);
                        break;
                    case "Computer":
                        prod[i] = list[1][0];
                        list[1].RemoveAt(0);
                        break;
                    case "Samsung": 
                        prod[i] = list[2][0];
                        list[2].RemoveAt(0);
                        break;
                }
            }
            return prod;
        }

        public void ShowProduct()
        {
            Console.WriteLine("商品名称\t商品数量\t单价\t");
            foreach(var item in list)
            {
                Console.WriteLine(item[0].Name + "    \t" + item.Count + "\t\t" + item[0].Price + "\t");
                //Console.Write(item[0].Name);
                //Console.SetCursorPosition(10);
            }
        }
    }
}


//for (int i = 0; i < 10; i++)
//            {
//                Console.Write("吨数:");
//                var t = Console.ReadLine();
//                Console.SetCursorPosition(10, i);
//                Console.WriteLine("周期:{0}?", t);
//            }