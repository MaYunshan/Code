using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;
using System.IO;

namespace 删除xml节点
{
    class Program
    {
        static void Main(string[] args)
        {
            XmlDocument doc = new XmlDocument();
            doc.Load(@"D:\12345C#\XML\XML基本使用\删除xml节点\Orders.xml");

            XmlNode node = doc.SelectSingleNode("/order/Items");
            node.RemoveAll();

            doc.Save(@"D:\12345C#\XML\XML基本使用\删除xml节点\Orders.xml");
            Console.ReadKey();
        }
    }
} 
