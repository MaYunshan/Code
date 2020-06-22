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

namespace ExecuteReader
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
            cmd.CommandText = "select * from kc";
            cmd.CommandType = CommandType.Text;

            //sqlDataReader的默认位置在第一条记录的前面，因此必须调用read方法访问数据，
            //read方法使SQLDataReader前进到下一条记录
            SqlDataReader sdr = cmd.ExecuteReader();
            while(sdr.Read())
            {
                listView1.Items.Add(sdr[0].ToString());
            }
            conn.Dispose();
            button1.Enabled = false;
        }
    }
}
