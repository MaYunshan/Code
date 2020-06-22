using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;
using System.Xml.Linq;

namespace XML读取带有属性的文档
{
    class Program
    {
        static void Main(string[] args)
        {
            //创建xml文档对象和读取文件
            XDocument xDoc = XDocument.Load(@"D:\12345C#\XML\XML读取带有属性的文档\XML读取带有属性的文档\订单.xml");

            //获得根节点
            XElement xRoot = xDoc.Root;

            Console.WriteLine("订购人：{0}", xRoot.Element("CustomName").Value);
            Console.WriteLine("订单编号：{0}", xRoot.Element("OrderNumber").Value);
            Console.WriteLine("订购商品详细信息：");

            foreach(var item in xRoot.Element("Item").Elements("OrderItem"))
            {
                Console.WriteLine("商品名称：{0},订购数量：{1}",item.Attribute("Name").Value,item.Attribute("Count").Value);
            }
        }
    }
}
