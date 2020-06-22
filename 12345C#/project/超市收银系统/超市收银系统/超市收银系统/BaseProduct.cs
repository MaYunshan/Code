using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 超市收银系统
{
    class BaseProduct
    {
        public double Price
        {
            get;
            set;
        }

        public string Name
        {
            get;
            set;
        }

        public string ID
        {
            get;
            set;
        }
        public BaseProduct(double price,string name,string id)
        {
            this.Price = price;
            this.Name = name;
            this.ID = id;
        }
    }
}
