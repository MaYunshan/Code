using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 深复制和浅复制
{
    class Program
    {
        public static void Main()
        {
            //创建P1对象
            Person p1 = new Person();
            p1.Age = 42;
            p1.Name = "Sam";
            p1.IdInfo = new IdInfo("081309207");

            //通过浅复制 得到P2对象
            Person p2 = p1.ShallowCopy();
            //分别输出
            Console.WriteLine("对象P1相关属性如下");
            DisplayValues(p1);
            //p1.Name = "";
            //p1.IdInfo.IdNumber = "XXXXX";
            Console.WriteLine("对象P2相关属性如下");
            DisplayValues(p2);

            //现在测试深复制
            Person p3 = p1.DeepCopy();

            p1.Name = "George";
            p1.Age = 39;
            p1.IdInfo.IdNumber = "081309208";
            Console.WriteLine("对象P1相关属性如下");
            DisplayValues(p1);
            //p1.IdInfo.IdNumber = "CCCCCCC";
            Console.WriteLine("对象P3相关属性如下");
            DisplayValues(p3);
            Console.Read();
        }

        public static void DisplayValues(Person p)
        {
            Console.WriteLine("      Name: {0:s}, Age: {1:d}", p.Name, p.Age);
            Console.WriteLine("      Value: {0:d}", p.IdInfo.IdNumber);
        }
    }

    public class IdInfo
    {
        public string IdNumber;

        public IdInfo(string IdNumber)
        {
            this.IdNumber = IdNumber;
        }
    }

    public class Person
    {
        public int Age;
        public string Name;
        public IdInfo IdInfo;

        public Person ShallowCopy()
        {
            return (Person)this.MemberwiseClone();
        }

        public Person DeepCopy()
        {
            Person other = (Person)this.MemberwiseClone();
            other.IdInfo = new IdInfo(IdInfo.IdNumber);
            other.Name = String.Copy(Name);
            return other;
        }
    }
}
