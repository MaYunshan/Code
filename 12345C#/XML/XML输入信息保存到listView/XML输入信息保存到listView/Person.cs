using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace XML输入信息保存到listView
{
    public class Person
    {
        public Person()
        {

        }

        public Person(string name,int age,string id,string email)
        {
            this.Name = name;
            this.Age = age;
            this.Id = id;
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
        public string Id
        {
            get;
            set;
        }
        public string Email
        {
            get;
            set;
        }

       
        public override string ToString()
        {
            return this.Name;
        }
    }
}
