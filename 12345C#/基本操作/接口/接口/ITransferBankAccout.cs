using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 接口
{
    interface ITransferBankAccout:IBankAccount
    {
        bool TransferTo(IBankAccount youAccount, decimal amount);
    }
}
