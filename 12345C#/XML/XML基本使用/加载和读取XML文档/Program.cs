using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using System.Xml;

namespace 加载和读取XML文档
{
    class Program
    {
        static void Main(string[] args)
        {
            XmlDocument doc = new XmlDocument();
            doc.Load(@"D:\12345C#\XML\XML基本使用\加载和读取XML文档\Books.xml");

            //获得根节点
            XmlElement books = doc.DocumentElement;

            //返回子节点的集合
            XmlNodeList xnl = books.ChildNodes;
            foreach(XmlNode node in xnl)
            {
                Console.WriteLine(node.InnerText);
            }

            //获取带有属性的xml文档

            XmlDocument doc1 = new XmlDocument();
            doc1.Load(@"D:\12345C#\XML\XML基本使用\加载和读取XML文档\Orders.xml");

            XmlNodeList xnl1 = doc1.SelectNodes("/order/Items/OrderItem");
            foreach(XmlNode node in xnl1)
            {
                Console.WriteLine(node.Attributes["Name"].Value);
                Console.WriteLine(node.Attributes["Count"].Value);
            }




            Console.ReadKey();
        }
    }
}
