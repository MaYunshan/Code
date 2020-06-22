using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 超市收银系统
{
    class NoDiscount:BaseDiscount
    {
        /// <summary>
        /// 不打折
        /// </summary>
        /// <param name="totalMoney"></param>
        /// <returns></returns>
        public override double GetAfterDiscountMoney(double totalMoney)
        {
            return totalMoney;
        }
    }
}
