using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml;
using System.IO;
using System.Xml.Linq;

namespace XML文件的使用
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btn_readXML_Click(object sender, EventArgs e)
        {
            #region  通过xDocument的方式来加载xml文件

            ////加载当前xml文件
            //XDocument xDoc = XDocument.Load(@"D:\12345前端\12345XML\XML文件的使用\XML文件的使用\stud.xml");

            ////先获取根节点
            //XElement xRoot = xDoc.Root;

            ////将xml文档的根节点添加到treeView的根节点上
            //TreeNode nodeRoot = treeView1.Nodes.Add(xRoot.Name.ToString());

            ////递归加载
            //LoadXmlToTree(xRoot, nodeRoot.Nodes);

            #endregion

            #region 通过xmlDocument的方式来加载xml文件

            //1.加载xml文件
            XmlDocument xDoc = new XmlDocument();
            xDoc.Load(@"D:\12345C#\XML\XML文件的使用\XML文件的使用\Person.xml");

            //2.获取根节点
            XmlElement xRoot = xDoc.DocumentElement;

            //3.将根节点添加到treeView的根节点上
            TreeNode rootNode = treeView1.Nodes.Add(xRoot.Name);

            //递归的加载
            LoadToTreeXmlDocument(xRoot, rootNode.Nodes);




            #endregion
        }

        private void LoadToTreeXmlDocument(XmlElement xRoot, TreeNodeCollection rootNode)
        {
            //循环遍历根节点xRoot下的所有子节点
            foreach(XmlNode item in xRoot.ChildNodes)
            {
                //判断当前子节点是什么类型的节点
                if(item.NodeType==XmlNodeType.Element)
                {
                    //如果当前节点是元素类型，则将它推荐爱到treeView中
                    TreeNode treeNode = rootNode.Add(item.Name);

                    //递归加载
                    LoadToTreeXmlDocument((XmlElement)item, treeNode.Nodes);

                }
                else if (item.NodeType == XmlNodeType.Text || item.NodeType == XmlNodeType.CDATA)
                {
                    rootNode.Add(item.InnerText);
                }
            }
        }

        private void LoadXmlToTree(XElement xRoot, TreeNodeCollection treeNodes)
        {
            //获取根节点xRoot下的所有的子元素
            //xRoot.Elements();

            //遍历xroot下的所有子元素
            foreach (XElement item in xRoot.Elements())
            {
                //如果当前子节点已经没有下一层子节点，即是一个叶子节点,则将内容添加进来
                if(item.Elements().Count()==0)
                {
                    treeNodes.Add(item.Name.ToString()).Nodes.Add(item.Value);
                }
                else
                {
                    //将遍历到的子元素添加到treeView中
                    TreeNode node = treeNodes.Add(item.Name.ToString());

                    //沿着当前的节点向下递归，
                    LoadXmlToTree(item, node.Nodes);
                }
               
            }
        }

        private void btn_writeXML_Click(object sender, EventArgs e)
        {
            #region 编程方式写入XML文档
           
            ////1.在内存中创建一个Dom对象
            //XmlDocument doc = new XmlDocument();

            ////2.增加一个文档说明
            //XmlDeclaration dec = doc.CreateXmlDeclaration("1.0", "utf-8", null);
            //doc.AppendChild(dec);

            ////为文档增加一个根元素
            //XmlElement xmlRoot = doc.CreateElement("School");
            //doc.AppendChild(xmlRoot);

            ////为根节点School增加class子节点,属性id=c01
            //XmlElement xmlClass1 = doc.CreateElement("class");

            ////设置属性
            //XmlAttribute attrClass1 = doc.CreateAttribute("id");
            //attrClass1.Value = "c01";
           
            ////追加属性和节点
            //xmlClass1.Attributes.Append(attrClass1);
            //xmlRoot.AppendChild(xmlClass1);

            ////为classc01添加student节点
            //XmlElement xmlStud1 = doc.CreateElement("Student");
            
            //XmlAttribute attrStud1 = doc.CreateAttribute("id");
            //attrStud1.Value = "s011";
            
            //xmlStud1.Attributes.Append(attrStud1);
            //xmlClass1.AppendChild(xmlStud1);

            ////添加属性
            //XmlElement xmlName1 =doc.CreateElement("Name");
            //xmlName1.InnerText = "唐作程";
            //xmlStud1.AppendChild(xmlName1);

            //XmlElement xmlSex1 = doc.CreateElement("Sex");
            //xmlSex1.InnerText = "男";
            //xmlStud1.AppendChild(xmlSex1);

            //XmlElement xmlAge1 = doc.CreateElement("Age");
            //xmlAge1.InnerText = "20";
            //xmlStud1.AppendChild(xmlAge1);

            



            //doc.Save("School.xml");
            //MessageBox.Show("保存成功");

            #endregion

            #region 将list集合里的元素写入xml文档 通过xmlDocument
            //List<Person> list = new List<Person>();
            //list.Add(new Person() { Name = "唐作程1", Age = 20, Sex = "男" });
            //list.Add(new Person() { Name = "唐作程2", Age = 21, Sex = "女" });
            //list.Add(new Person() { Name = "唐作程3", Age = 22, Sex = "男" });
            //list.Add(new Person() { Name = "唐作程4", Age = 23, Sex = "女" });

            ////创建一个xml文档对象
            //XmlDocument doc = new XmlDocument();

            ////增加一个文档说明
            //XmlDeclaration dec = doc.CreateXmlDeclaration("1.0", "utf-8", null);
            //doc.AppendChild(dec);

            ////增加一个根节点
            //XmlElement xmlRoot = doc.CreateElement("Person");
            //doc.AppendChild(xmlRoot);

            ////循环添加节点
            //for(int i=0;i<list.Count;i++)
            //{
            //    XmlElement xmlPerson = doc.CreateElement("Person");
            //    XmlAttribute attr = doc.CreateAttribute("id");
            //    attr.Value = (i + 1).ToString();
            //    xmlPerson.Attributes.Append(attr);

            //    //向person节点下添加子节点
            //    XmlElement xmlName = doc.CreateElement("Name");
            //    xmlName.InnerText = list[i].Name;
            //    xmlPerson.AppendChild(xmlName);

            //    XmlElement xmlAge = doc.CreateElement("Age");
            //    xmlAge.InnerText = list[i].Age.ToString();
            //    xmlPerson.AppendChild(xmlAge);

            //    XmlElement xmlSex = doc.CreateElement("Sex");
            //    xmlSex.InnerText = list[i].Sex;
            //    xmlPerson.AppendChild(xmlSex);


            //    //把person属性添加到根节点下面
            //    xmlRoot.AppendChild(xmlPerson);
            //}

            //doc.Save(@"D:\12345前端\12345XML\XML文件的使用\Person.xml");
            //MessageBox.Show("保存成功");

            #endregion

            #region 将list集合里的元素写入xml文档 通过XDocument

            List<Person> list = new List<Person>();
            list.Add(new Person() { Name = "唐作程1", Age = 20, Sex = "男" });
            list.Add(new Person() { Name = "唐作程2", Age = 21, Sex = "女" });
            list.Add(new Person() { Name = "唐作程3", Age = 22, Sex = "男" });
            list.Add(new Person() { Name = "唐作程4", Age = 23, Sex = "女" });

            //创建一个Dom对象
            XDocument xDoc = new XDocument();

            //创建声明
            XDeclaration xDec = new XDeclaration("1.0", "utf-8", null);
            xDoc.Declaration = xDec;

            //创建根节点
            XElement xRoot = new XElement("List");
            xDoc.Add(xRoot);

            //循环添加节点信息
            for(int i=0;i<list.Count;i++)
            {
                XElement xPerson = new XElement("Person");
                xPerson.SetAttributeValue("id", (i + 1).ToString());

                xPerson.SetElementValue("Name", list[i].Name);
                xPerson.SetElementValue("Age", list[i].Age);
                xPerson.SetElementValue("Sex", list[i].Sex);

                xRoot.Add(xPerson);
            }

            xDoc.Save(@"D:\12345前端\12345XML\XML文件的使用\Person1.xml");
            MessageBox.Show("保存成功");

            #endregion
        }

        private void btn_getOneNode_Click(object sender, EventArgs e)
        {
            #region 通过xmlDocument快速搜寻节点

            //XmlDocument xDoc = new XmlDocument();

            ////加载xml文档
            //xDoc.Load(@"D:\12345前端\12345XML\XML文件的使用\XML文件的使用\stud.xml");



            ////通过id获得指定元素时需要有文档规范
            ////XmlNodeList xNodeList = xDoc.GetElementsByTagName("stu");
            ////foreach(XmlNode node in xNodeList)
            ////{
            ////    Console.WriteLine(node.Name);
            ////}
            #endregion

            #region 通过xdocument快速获得某一节点

            XDocument xDoc =XDocument.Load(@"D:\12345前端\12345XML\XML文件的使用\XML文件的使用\stud.xml");

            //获取根节点
            XElement root=xDoc.Root;

            IEnumerable<XElement> ie= root.Descendants("stu").Where(x=>Convert.ToInt32(x.Attribute("id").Value)==2);
            foreach(XElement xe in ie)
            {
                Console.WriteLine(xe.Attribute("id").Value+xe.Name);

                IEnumerable<XElement> IE = xe.Descendants();
                foreach(XElement xei in IE)
                {
                    Console.WriteLine(xei.Name+" "+xei.Value);
                }
            }
            #endregion
        }
    }

    public class Person
    {
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

        public string Sex
        {
            get;
            set;
        }

    }
}
