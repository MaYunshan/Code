using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;

namespace XML基本使用
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
            XmlElement books = doc.CreateElement("Books");
            //将根节点添加到文档中
            doc.AppendChild(books);

            //5,给根节点books添加子节点
            XmlElement book1 = doc.CreateElement("Book");
            //将book1添加到根节点
            books.AppendChild(book1);

            //6，给book1添加三个子节点
            XmlElement name1 = doc.CreateElement("Name");
            name1.InnerText = "三国演义";
            //将name1添加到book1节点中
            book1.AppendChild(name1);

            XmlElement price1 = doc.CreateElement("Price");
            price1.InnerText = "20";
            book1.AppendChild(price1);

            XmlElement dec1 = doc.CreateElement("Dec");
            dec1.InnerText = "东汉末年的故事";
            book1.AppendChild(dec1);


            //5,给根节点books添加子节点
            XmlElement book2 = doc.CreateElement("Book");
            //将book1添加到根节点
            books.AppendChild(book2);

            //6，给book1添加三个子节点
            XmlElement name2 = doc.CreateElement("Name");
            name2.InnerText = "水浒传";
            //将name1添加到book1节点中
            book2.AppendChild(name2);

            XmlElement price2 = doc.CreateElement("Price");
            price2.InnerText = "30";
            book2.AppendChild(price2);

            XmlElement dec2 = doc.CreateElement("Dec");
            dec2.InnerText = "北宋末年108个人物的故事";
            book2.AppendChild(dec2);

            doc.Save("Books.xml");
            Console.WriteLine("创建成功");
            Console.ReadKey();
        }
    }
}
