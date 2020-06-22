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
    public partial class FrmLogin : Form
    {
        public FrmLogin()
        {
            InitializeComponent();
        }

        private void btnLog_Click(object sender, EventArgs e)
        {
            if(txtInLogID.Text==null||txtInPwd.Text==null)
            {
                MessageBox.Show("请输入完整的用户名和密码");
                return;
            }
            else
            {
                string log = txtInLogID.Text;
                string pwd = txtInPwd.Text;

                XmlDocument xDoc = new XmlDocument();
                xDoc.Load(@"D:\12345C#\XML\把XML当做数据库实现增删改查\把XML当做数据库实现增删改查\userData.xml");

                XmlNode nameNode = xDoc.SelectSingleNode("/users/user/name[.='" + log + "']");
                if(nameNode==null)
                {
                    MessageBox.Show("不存在当前用户名!");
                    return;
                }
                else
                {
                    XmlNode pwdNode = nameNode.NextSibling;
                    if(pwdNode.InnerText!=pwd)
                    {
                        MessageBox.Show("密码错误！");
                    }
                    else
                    {
                        Form1 fEdit = new Form1();
                        fEdit.Show();
                        this.Hide();
                    }
                }
            }
        }
    }
}
