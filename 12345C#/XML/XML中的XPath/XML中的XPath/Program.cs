using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;
using System.Xml.Linq;

namespace XML中的XPath
{
    class Program
    {
        static void Main(string[] args)
        {
            XmlDocument xDoc = new XmlDocument();
            xDoc.Load(@"D:\12345C#\XML\XML中的XPath\XML中的XPath\Person1.xml");

            XmlNodeList nodeList = xDoc.SelectNodes("//Person");
            foreach(XmlNode node in nodeList)
            {
                Console.WriteLine(node.Name + "\t" + node.Attributes["id"].Value+"\t"+node.Attributes["position"].Value);
            }
            Console.ReadKey();
        }
    }
}
