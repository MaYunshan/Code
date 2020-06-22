using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 超市收银系统
{
    
    class SuperMarket
    {
        //创建仓库对象
        ProductHouse prodHouse = new ProductHouse();

        /// <summary>
        /// 初始时向货架中添加商品
        /// </summary>
        public SuperMarket()
        {
            prodHouse.Stock("Banana", 100);
            prodHouse.Stock("Computer", 100);
            prodHouse.Stock("Samsung", 100);
        }

        /// <summary>
        /// 询问客户需要的商品及数量
        /// </summary>
        public void AskCustomer()
        {
            Console.WriteLine("欢迎光临，请问您需要些什么？");
            Console.WriteLine("我们有Banana Samsung Computer");
            string prodType = Console.ReadLine();
            Console.WriteLine("请问你需要多少？");
            int count = Convert.ToInt32(Console.ReadLine());

            BaseProduct[] prods = prodHouse.Fetch(prodType, count);

            double Money = GetPrice(prods);
            Console.WriteLine("你一共需要支付" + Money + "元");

            Console.WriteLine("请选择你的折扣方式");
            Console.WriteLine("\t1--不打折");
            Console.WriteLine("\t2--打九折");
            Console.WriteLine("\t3--打八五折");
            Console.WriteLine("\t4--满300减50");
            Console.WriteLine("\t5--满500减100");

            //通过简单工厂设计模式获得用户的打折模式
            string input = Console.ReadLine();
            BaseDiscount dis = GetDiscount(input);
            double finalMoney=dis.GetAfterDiscountMoney(Money);
            Console.WriteLine("打完折以后的总金额是{0}", finalMoney);
        }

        /// <summary>
        /// 根据用户的输入选择折扣类型
        /// </summary>
        /// <param name="input"></param>
        /// <returns></returns>
        public BaseDiscount GetDiscount(string input)
        {
            BaseDiscount dis = null;
            switch(input)
            {
                case "1": dis = new NoDiscount();
                    break;
                case "2": dis = new DiscountRate(0.9);
                    break;
                case "3": dis = new DiscountRate(0.85);
                    break;
                case "4": dis = new DiscountBuyMSendN(300, 50);
                    break;
                case "5": dis = new DiscountBuyMSendN(500, 100);
                    break;
            }
            return dis;
        }

        /// <summary>
        /// 计算商品的总价格
        /// </summary>
        /// <param name="prods"></param>
        /// <returns></returns>
        public double GetPrice(BaseProduct[] prods)
        {
            double totalMoney = 0;
            for(int i=0;i<prods.Length;i++)
            {
                totalMoney += prods[i].Price;
            }
            return totalMoney;
        }

        public void ShowProds()
        {
            prodHouse.ShowProduct();
        }
    }
}
