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

namespace 数据适配器
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
            //创建一个连接对象，有效就可以，但是不需要open
            conn = new SqlConnection("server=DESKTOP-RUSEPIQ;database=xsxk;uid=sa;pwd=123");

            SqlCommand cmd = new SqlCommand("select * from xs", conn);

            //创建一个数据适配器对象，是dataset与数据源之间的桥梁
            SqlDataAdapter sda = new SqlDataAdapter();
            //从数据库获得数据
            sda.SelectCommand = cmd;

            DataSet ds = new DataSet();
            //将获得的数据保存到dataset中
            sda.Fill(ds, "xs");

            //拿出dataset中的第一张表格
            dataGridView1.DataSource = ds.Tables[0];
        }

    }
}
