using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 对象的相等
{
    class Program
    {
        static void Main(string[] args)
        {
            MYS m1 = new MYS(2);
            MYS m2 = new MYS(2);
            Console.WriteLine(ReferenceEquals(m1, m2));
            Console.WriteLine(Equals(m1, m2));
            Console.ReadLine();
        }
    }

    class MYS
    {
        private int a;
        public MYS(int b)
        {
            a = b;
        }
        public override bool Equals(object obj)
        {
            if ((obj == null) || (obj.GetType() != typeof(MYS)))
                return false;
            MYS m3 = (MYS)obj;
            if (m3.a == this.a)
                return true;
            else
                return false;
        }
    }
}
