using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

/*
 *接口可以实现多态，还可以被继承
 *一个接口，多种实现 
 */
namespace 接口
{
    class Program
    {
        static void Main(string[] args)
        {
            IBankAccount myAccount = new SaverAccount();
            myAccount.PayIn(1000);
            myAccount.WithShowMySelf(200);
            Console.WriteLine("余额" + myAccount.Balance);
        }
    }

    class SaverAccount:IBankAccount
    {
        private decimal banlance;
        public void PayIn(decimal amount)
        {
            banlance += amount;
        }
        public bool WithShowMySelf(decimal amount)
        {
            if(banlance>=amount)
            {
                banlance -= amount;
                return true;
            }
            else
            {
                Console.WriteLine("取款失败!");
                return false;
            }
        }
        public decimal Balance 
        {
            get { return banlance; }
        }
    }

    class TransferAccount:ITransferBankAccout
    {
        private decimal banlance;
        public void PayIn(decimal amount)
        {
            banlance += amount;
        }
        public bool WithShowMySelf(decimal amount)
        {
            if (banlance >= amount)
            {
                banlance -= amount;
                return true;
            }
            else
            {
                Console.WriteLine("取款失败!");
                return false;
            }
        }
        public decimal Balance
        {
            get { return banlance; }
        }

        bool TransferTo(IBankAccount youAccount, decimal amount)
        {
            bool result=WithShowMySelf(amount);
            if (result)
                youAccount.PayIn(amount);
            return result;
        }
    }
}
