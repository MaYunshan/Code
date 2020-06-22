using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 超市收银系统
{
    abstract class BaseDiscount
    {
        /// <summary>
        /// 关于打折的基类
        /// </summary>
        /// <param name="totalMoney">打折前的总金额</param>
        /// <returns>打折后的金额</returns>
        public abstract double GetAfterDiscountMoney(double totalMoney);
    }
}
