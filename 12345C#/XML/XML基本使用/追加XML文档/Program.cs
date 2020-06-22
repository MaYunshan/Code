using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;
using System.IO;

namespace 追加XML文档
{
    class Program
    {
        static void Main(string[] args)
        {
            //追加XML文档
            XmlDocument doc = new XmlDocument();
            XmlElement books;
            if (File.Exists(@"D:\12345C#\XML\XML基本使用\追加XML文档\Books.xml"))
            {
                //若文档存在，先加载
                doc.Load(@"D:\12345C#\XML\XML基本使用\追加XML文档\Books.xml");
                //获取根节点
                books = doc.DocumentElement;         
            }
            else
            {
                //若文档不存在
                XmlDeclaration dec = doc.CreateXmlDeclaration("1.0", "utf-8", null);
                doc.AppendChild(dec);

                //创建根节点
                books = doc.CreateElement("Books");
                doc.AppendChild(books);
            }

            //5,给根节点books添加子节点
            XmlElement book2 = doc.CreateElement("Book");
            //将book1添加到根节点
            books.AppendChild(book2);

            XmlElement name2 = doc.CreateElement("Name");
            name2.InnerText = "西游记";
            //将name1添加到book1节点中
            book2.AppendChild(name2);

            XmlElement price2 = doc.CreateElement("Price");
            price2.InnerText = "30";
            book2.AppendChild(price2);

            XmlElement dec2 = doc.CreateElement("Dec");
            dec2.InnerText = "唐玄奘和他的三个徒弟的故事";
            book2.AppendChild(dec2);

            doc.Save(@"D:\12345C#\XML\XML基本使用\追加XML文档\Books.xml");
            Console.WriteLine("追加成功");
            Console.ReadKey();
        }
    }
}
