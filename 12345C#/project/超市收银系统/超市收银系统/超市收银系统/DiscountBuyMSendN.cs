using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 超市收银系统
{
    class DiscountBuyMSendN:BaseDiscount
    {
        public double M
        {
            get;
            set;
        }
        public double N
        {
            get;
            set;
        }

        public DiscountBuyMSendN(double M,double N)
        {
            this.M = M;
            this.N = N;
        }
        /// <summary>
        /// 满M减N
        /// </summary>
        /// <param name="totalMoney"></param>
        /// <returns></returns>
        public override double GetAfterDiscountMoney(double totalMoney)
        {
            //600-100
            //1200-200
            if(totalMoney>=M)
            {
                totalMoney -= (int)(totalMoney / M) * N;
            }
            return totalMoney;
        }
    }
}
