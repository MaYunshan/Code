using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 特性1
{
    [AttributeUsage(AttributeTargets.All, Inherited = true, AllowMultiple = true)]
    class AnimalInfoAttribute:Attribute
    {
        
        private string name;          //名称
        private string phylum;        //门
        private string classis;       //纲
        private string familia;        //科

        public AnimalInfoAttribute(string nameValue, string familiaValue)
        {
            name = nameValue;
            familia = familiaValue;
        }

        public string Name
        {
            get { return name; }
            set { name = value; }
        }

        public string Phylum
        {
            get { return phylum; }
            set { phylum = value; }
        }
        
        public string Classis
        {
            get { return classis; }
            set { classis = value; }
        }       

        public string Familia
        {
            get { return familia; }
            set { familia = value; }
        }

      
    }
}
