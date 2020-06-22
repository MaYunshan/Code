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
using System.Xml.Linq;

namespace 把XML当做数据库实现增删改查
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            #region 加载窗体的时候将数据添加到ListView中
            LoadXML();

            #endregion
        }

        private void LoadXML()
        {
            listView1.Items.Clear();
            //读取XML文档
            XmlDocument xDoc = new XmlDocument();
            xDoc.Load(@"D:\12345C#\XML\把XML当做数据库实现增删改查\把XML当做数据库实现增删改查\userData.xml");

            //用xPath的方式找到所有的user节点
            XmlNodeList nodeList = xDoc.SelectNodes("//user");
            foreach (XmlNode userNode in nodeList)
            {
                //创建一个ListViewItem的对象，用来将它添加到listview中
                ListViewItem lVItem = new ListViewItem(userNode.Attributes["id"].Value);

                //将子节点也添加进来
                lVItem.SubItems.Add(userNode.SelectSingleNode("name").InnerText);
                lVItem.SubItems.Add(userNode.SelectSingleNode("password").InnerText);

                listView1.Items.Add(lVItem);
            }
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            string id = txtId.Text.Trim();
            string name = txtLogId.Text.Trim();
            string password = txtPwd.Text.Trim();

            //向xml文档中添加user节点，先加载，获得根节点，创建新节点
            XmlDocument xDoc = new XmlDocument();
            xDoc.Load(@"D:\12345C#\XML\把XML当做数据库实现增删改查\把XML当做数据库实现增删改查\userData.xml");
            XmlElement xRoot = xDoc.DocumentElement;

            XmlElement xUser = xDoc.CreateElement("user");
            //检查id是否已经存在
            if(xDoc.SelectNodes("/users/user[@id='"+id+"']").Count>0)
            {
                MessageBox.Show("当前id已经存在，请重新确认id");
            }
            else
            {
                xUser.SetAttribute("id", id);          

                XmlElement xName = xDoc.CreateElement("name");
                xName.InnerText = name;

                XmlElement xPass = xDoc.CreateElement("password");
                xPass.InnerText = password;

                xUser.AppendChild(xName);
                xUser.AppendChild(xPass);

                xRoot.AppendChild(xUser);
            }
            xDoc.Save(@"D:\12345C#\XML\把XML当做数据库实现增删改查\把XML当做数据库实现增删改查\userData.xml");
            LoadXML();
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            //先获取选中项
            XmlDocument xDoc = new XmlDocument();
            xDoc.Load(@"D:\12345C#\XML\把XML当做数据库实现增删改查\把XML当做数据库实现增删改查\userData.xml");
            if(listView1.SelectedItems.Count>0)
            {
                string id = listView1.SelectedItems[0].SubItems[0].Text;

                XmlNode xUser = xDoc.SelectSingleNode("/users/user[@id='" + id + "']");
                if(xUser!=null)
                {
                    xDoc.DocumentElement.RemoveChild(xUser);
                }
            }
            xDoc.Save(@"D:\12345C#\XML\把XML当做数据库实现增删改查\把XML当做数据库实现增删改查\userData.xml");
            LoadXML();
        }

        private void btnModify_Click(object sender, EventArgs e)
        {
   
            XmlDocument xDoc = new XmlDocument();
            xDoc.Load(@"D:\12345C#\XML\把XML当做数据库实现增删改查\把XML当做数据库实现增删改查\userData.xml");
           
            //先找到要修改的id的节点
            string id = txtEditId.Text;
            XmlNode xUser = xDoc.SelectSingleNode("/users/user[@id='" + id + "']");
            xUser.SelectSingleNode("name").InnerText = txtEditLogId.Text.Trim();
            xUser.SelectSingleNode("password").InnerText = txtEditPwd.Text.Trim();

            xDoc.Save(@"D:\12345C#\XML\把XML当做数据库实现增删改查\把XML当做数据库实现增删改查\userData.xml");
            LoadXML();
        }

        private void listView1_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (listView1.SelectedItems.Count > 0)
            {
                txtEditId.Text = listView1.SelectedItems[0].SubItems[0].Text;
                txtEditLogId.Text = listView1.SelectedItems[0].SubItems[1].Text;
                txtEditPwd.Text = listView1.SelectedItems[0].SubItems[2].Text;
            }
        }
    }
}
