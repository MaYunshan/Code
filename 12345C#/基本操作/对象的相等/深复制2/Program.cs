using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 深复制2
{
    class Program
    {
        static void Main(string[] args)
        {
            Resume Rbill = new Resume("bill");
            Rbill.SetPersonalInfo("man", "11");
            Rbill.SetWorkExperience("2015-1-2-2015-12-10", "IBM");

            Resume Rcindy = (Resume)Rbill.Clone();
            Rcindy.SetWorkExperience("2015-1-2至2015-11-11", "Microsoft");

            Resume Rll = (Resume)Rbill.Clone();
            Rll.SetPersonalInfo("rll", "99");
            Rll.SetWorkExperience("2015-1-2至2015-11-11", "甲骨文");

            Rbill.Display();
            Rcindy.Display();
            Rll.Display();
            Console.Read();
        }
    }

    public class Resume : ICloneable
    {
        private string name;
        private string age;
        private string sex;

        private Workexperience work;
        public Resume(string strName)
        {
            this.name = strName;
            work = new Workexperience();        //在初始化Resume的同时实例化一个Workexperience对象。  
        }

        //提供clone 方法调用的私有构造函数，以便克隆数据。  
        private Resume(Workexperience work)
        {
            //这个私有的构造函数用来实现Workexperience对象的浅复制，因为Workexperience里面没有对象，这一步浅复制会把它的字段按照值类型复制
            this.work = (Workexperience)work.Clone();
        }
        public void SetPersonalInfo(string sex, string age)
        {
            this.sex = sex;
            this.age = age;
        }

        public void SetWorkExperience(string workDate, string company)
        {
            work.WorkDate = workDate;
            work.Company = company;

        }

        public void Display()
        {
            Console.WriteLine("{0},{1},{2}", name, sex, age);
            Console.WriteLine("{0},{1}", work.WorkDate, work.Company);   // 引用work类的属性、字段。  

        }

        public object Clone()
        {
            Resume obj = new Resume(this.work);  //调用私有构造函数，完成克隆，并给简历对象的相关字段赋值，返回深复制简历对象  
            obj.name = name;
            obj.sex = sex;
            obj.age = age;
            return obj;


        }
    }
    class Workexperience : ICloneable
    {
        private string workDate;
        private string company;

        public string WorkDate
        {
            get { return workDate; }
            set { workDate = value; }
        }
        public string Company
        {
            get { return company; }
            set { company = value; }
        }

        public object Clone()
        {
            return (object)this.MemberwiseClone();
        }
    }  
}
