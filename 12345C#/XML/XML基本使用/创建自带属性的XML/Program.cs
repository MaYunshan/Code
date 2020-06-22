using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;

namespace 创建自带属性的XML
{
    class Program
    {
        static void Main(string[] args)
        {
            //通过代码创建XML文档
            //1，引用命名空间
            //2，创建XML文档对象
            XmlDocument doc = new XmlDocument();

            //3,创建第一个行描述信息，并且添加到第一行
            XmlDeclaration dec = doc.CreateXmlDeclaration("1.0", "utf-8", null);
            doc.AppendChild(dec);

            //4，创建根节点
            XmlElement order = doc.CreateElement("order");
            doc.AppendChild(order);

            XmlElement customName = doc.CreateElement("CustomName");
            order.AppendChild(customName);
            customName.InnerText = "刘洋";

            XmlElement orderNumber = doc.CreateElement("OrderNumber");
            orderNumber.InnerText = "bj0000001";
            order.AppendChild(orderNumber);

            XmlElement item = doc.CreateElement("Items");
            order.AppendChild(item);

            XmlElement orderItem1 = doc.CreateElement("OrderItem");
            //给节点添加属性
            orderItem1.SetAttribute("Name","码表");
            orderItem1.SetAttribute("Count", "10");
            item.AppendChild(orderItem1);

            XmlElement orderItem2 = doc.CreateElement("OrderItem");
            //给节点添加属性
            orderItem2.SetAttribute("Name", "手表");
            orderItem2.SetAttribute("Count", "10");
            item.AppendChild(orderItem2);

            XmlElement orderItem3 = doc.CreateElement("OrderItem");
            //给节点添加属性
            orderItem3.SetAttribute("Name", "怀表");
            orderItem3.SetAttribute("Count", "10");
            item.AppendChild(orderItem3);


            doc.Save("Orders.xml");
            Console.WriteLine("创建成功");
            Console.ReadKey();
        }
    }
}
