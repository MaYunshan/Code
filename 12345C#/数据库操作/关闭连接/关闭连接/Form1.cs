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
namespace 关闭连接
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        SqlConnection conn;
        private void button1_Click(object sender, EventArgs e)
        {
            if (textBox1.Text == "")
            {
                MessageBox.Show("请输入要连接的数据库");
            }
            else
            {
                try
                {
                    string dbStr = "server=DESKTOP-RUSEPIQ;database=" + textBox1.Text.Trim() + ";uid=sa;pwd=123";

                    conn = new SqlConnection(dbStr);
                    conn.Open();

                    if (conn.State == ConnectionState.Open)
                    {
                        MessageBox.Show("连接成功");
                    }
                }
                catch(Exception ex)
                {
                    MessageBox.Show(ex.Message);
                    textBox1.Text = "";
                }
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            try
            {
                string str = "";
                conn.Close();
                if(conn.State==ConnectionState.Closed)
                {
                    str = "数据库已经成功关闭\n";
                }

                conn.Open();
                if (conn.State == ConnectionState.Open)
                {
                    str = "数据库已经成功打开\n";
                }
                richTextBox1.Text = str;
            }
            catch(Exception ex)
            {
                richTextBox1.Text = ex.Message;
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            try
            {
                conn.Dispose();
                conn.Close();
            }
            catch(Exception ex)
            {
                richTextBox1.Text = ex.Message;
            }
        }
    }
}
