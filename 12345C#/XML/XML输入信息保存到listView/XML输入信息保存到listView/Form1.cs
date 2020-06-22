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

namespace XML输入信息保存到listView
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        //建立一个字典放置重复添加信息
        Dictionary<string, Person> dict = new Dictionary<string, Person>();
        private void btnSet_Click(object sender, EventArgs e)
        {
            Person person = new Person(txtName.Text.Trim(), int.Parse(txtAge.Text.Trim()), txtID.Text.Trim(), txtEmail.Text.Trim());
            if(dict.ContainsKey(txtID.Text.Trim()))
            {
                //如果已经存在该键值，则修改字典中已经存在的键值
                dict[person.Id] = person;
                //listBox中的值也需要修改
                listBox1.Items[listBox1.SelectedIndex] = person;
            }
            else
            {
                //不存在就添加
                listBox1.Items.Add(person);
                dict.Add(person.Id, person);
            }

            CleanTextBox();
            
        }

        /// <summary>
        /// 清除文本框中的内容
        /// </summary>
        private void CleanTextBox()
        {
            foreach(Control item in this.Controls)
            {
                if(item is TextBox)
                {
                    ((TextBox)item).Clear();
                }
            }
        }

        /// <summary>
        /// 点击退出按钮时将dict中的person对象保存到xml中
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        
        private void btnQuit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void ExitSave()
        {
            //创建一个xdocument文档对象
            XDocument xDoc = new XDocument();

            //创建根节点,并且将它添加到文档中
            XElement xRoot = new XElement("PersonList");
            xDoc.Add(xRoot);

            //遍历dict对象，将person对象添加到xml文档中
            foreach (KeyValuePair<string, Person> item in dict)
            {
                XElement xPerson = new XElement("Person");
                xPerson.SetElementValue("Name", item.Value.Name);
                xPerson.SetElementValue("ID", item.Value.Id);
                xPerson.SetElementValue("Age", item.Value.Age);
                xPerson.SetElementValue("Email", item.Value.Email);

                //将person节点添加到根节点下面
                xRoot.Add(xPerson);
            }

            xDoc.Save(@"D:\12345C#\XML\XML输入信息保存到listView\Person.xml");
        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            ExitSave();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            //窗体加载时将xml文件加载到listBox中
            XDocument xDoc = XDocument.Load(@"D:\12345C#\XML\XML输入信息保存到listView\Person.xml");

            //获得根节点
            XElement xRoot = xDoc.Root;

            //遍历根节点下的所有person节点
            foreach (XElement item in xRoot.Elements("Person"))
            {
                //将person节点下的信息提取到Person对象中
                Person person = new Person();
                person.Name = item.Element("Name").Value;
                person.Id = item.Element("ID").Value;
                person.Age = Convert.ToInt32(item.Element("Age").Value);
                person.Email = item.Element("Email").Value;

                //将信息添加到dict中
                if(!dict.ContainsKey(person.Id))
                {
                    dict.Add(person.Id, person);
                    listBox1.Items.Add(person);
                }
            }
        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            //将选中项的信息显示到文本框中
            if(listBox1.SelectedItem!=null)
            {
                Person person = listBox1.SelectedItem as Person;
                if(person!=null)
                {
                    txtName.Text = person.Name;
                    txtAge.Text = person.Age.ToString();
                    txtEmail.Text = person.Email;
                    txtID.Text = person.Id;
                }
            }
        }
    }
}
