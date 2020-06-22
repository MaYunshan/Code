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

namespace 连接数据库
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if(textBox1.Text=="")
            {
                MessageBox.Show("请输入要连接的数据库");
            }
            else
            {
                try
                {
                    string dbStr = "server=DESKTOP-RUSEPIQ;database=" + textBox1.Text.Trim() + ";uid=sa;pwd=123";

                    SqlConnection conn = new SqlConnection(dbStr);
                    conn.Open();

                    if (conn.State == ConnectionState.Open)
                    {
                        label2.Text = "数据库【" + textBox1.Text.Trim() + "】已经连接并打开";
                    }
                }
                catch
                {
                    MessageBox.Show("连接数据库失败");
                }
            }
            
        }
    }
}
