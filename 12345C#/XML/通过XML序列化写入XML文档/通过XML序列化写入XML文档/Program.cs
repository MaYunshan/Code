using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;
using System.Xml.Linq;
using System.Xml.Serialization;

namespace 通过XML序列化写入XML文档
{
    class Program
    {
        static void Main(string[] args)
        {
            List<Person> list = new List<Person>();
            list.Add(new Person("张三", 21, "zhang"));
            list.Add(new Person("李四", 18, "li"));
            list.Add(new Person("王五", 223, "wang"));
            list.Add(new Person("赵六", 24, "zhao"));

            //实现xml序列化
            XmlSerializer xml = new XmlSerializer(typeof(List<Person>));
            using(FileStream fs=File.OpenWrite("list.xml"))
            {
                xml.Serialize(fs, list);
            }
        }
    }

    public class Person
    {
        public Person()
        {

        }

        public Person(string name,int age,string email)
        {
            this.Name = name;
            this.Age = age;
            this.Email = email;
        }
        public string Name
        {
            get;
            set;
        }
        public int Age
        {
            get;
            set;
        }
        public string Email
        {
            get;
            set;
        }
    }
}
