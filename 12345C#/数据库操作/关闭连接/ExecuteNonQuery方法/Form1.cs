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
namespace ExecuteNonQuery方法
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
            conn = new SqlConnection("server=DESKTOP-RUSEPIQ;database=xsxk;uid=sa;pwd=123");
            conn.Open();
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = conn;
            cmd.CommandText = "update xs set 总学分=21 where 性别='女'";
            cmd.CommandType = CommandType.Text;
            int i = Convert.ToInt32(cmd.ExecuteNonQuery());
            Console.WriteLine(cmd.ExecuteNonQuery());
            Console.WriteLine(i);
            label2.Text = "共有" + i.ToString() + "名女员工获得奖金";
        }
    }
}
