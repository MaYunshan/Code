using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 接口
{
    interface IBankAccount
    {
        void PayIn(decimal amount);
        bool WithShowMySelf(decimal amount);
        decimal Balance { get; } //只读属性
    }
}
