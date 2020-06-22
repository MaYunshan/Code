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
namespace 数据库操作
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        SqlConnection conn;
        private void Form1_Load(object sender, EventArgs e)
        {
            //实例化一个sqlConnection对象
            //string dbStr = "server=DESKTOP-RUSEPIQ;database=xsxk1;uid=sa;pwd=123";
            conn = new SqlConnection("server=DESKTOP-RUSEPIQ;database=xsxk;uid=sa;pwd=123");
            conn.Open();    //连接到数据库
        }

        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                //如果数据库没有打开或者输入文本框的内容为空
                if (conn.State == ConnectionState.Open || textBox1.Text != "")
                {
                    //创建一个数据命令对象，用于向数据库中发送查询、更新、删除、修改等操作
                    SqlCommand cmd = new SqlCommand();

                    //设置connection对象
                    cmd.Connection = conn;
                    cmd.CommandText = "select count(*) from " + textBox1.Text.Trim();
                    cmd.CommandType = CommandType.Text;

                    int i = Convert.ToInt32(cmd.ExecuteScalar());
                    Console.WriteLine(i);
                    label2.Text = "数据表中共有：" + i.ToString() + "条数据";
                }
               
            }
            catch(Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }
    }
}
