using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;

namespace PWMS
{
    public partial class F_Login : Form
    {
        DataClass.MyMeans MyClass = new PWMS.DataClass.MyMeans();
        public F_Login()
        {
            InitializeComponent();
        }

        private void btn_login_Click(object sender, EventArgs e)
        {
            if (txt_name.Text != null && txt_password.Text != null)
            { 
                string strName=txt_name.Text.Trim();
                string strPwd=txt_password.Text.Trim();
                //格式化查询字符串

                //用户名和密码在数据库也有一张表，采用sqlDataReader直接查询，判断当前当前用户是否存在
                string str=string.Format("select * from tb_Login where Name='{0}' and Pass='{1}'",strName,strPwd);

                //向数据表中查询当前输入的用户名和密码，如果返回结果不为空，说明当前输入信息正确
                SqlDataReader sdr = MyClass.getcom(str);
                if(sdr.Read())
                {
                    DataClass.MyMeans.Login_Name = strName;
                    DataClass.MyMeans.Login_ID = sdr.GetString(0);
                    DataClass.MyMeans.My_con.Close();
                    DataClass.MyMeans.My_con.Dispose();
                    DataClass.MyMeans.Login_n = (int)(this.Tag);
                    this.Close();
                    //当前用户在登录表中存在时，登录界面退出，进入主界面
                }
                else
                {
                    MessageBox.Show("用户名或者密码错误", "提示", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    txt_name.Text = "";
                    txt_password.Text = "";
                }
                MyClass.con_close();
            }
            else
                MessageBox.Show("请将登录信息添写完整！", "提示", MessageBoxButtons.OK, MessageBoxIcon.Information);
        }

        private void btn_close_Click(object sender, EventArgs e)
        {
            if ((int)(this.Tag) == 1)
            {
                DataClass.MyMeans.Login_n = 3;
                Application.Exit();
            }
            else
            {
                if ((int)(this.Tag) == 2)
                    this.Close();
            }               
        }

        private void F_Login_Load(object sender, EventArgs e)
        {
            try
            {
                MyClass.con_open();  //连接数据库
                MyClass.con_close();
                txt_name.Text = "";
                txt_password.Text = "";

            }
            catch
            {
                MessageBox.Show("数据库连接失败。", "提示", MessageBoxButtons.OK, MessageBoxIcon.Information);
                Application.Exit();
            }
        }
        private void txt_name_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar == '\r')
                txt_name.Focus();
        }

        private void txt_password_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar == '\r')
                txt_password.Focus();
        }

        private void F_Login_Activated(object sender, EventArgs e)
        {
            txt_name.Focus();
        }
    }
}
