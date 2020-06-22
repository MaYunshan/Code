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

namespace 合并dataset
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
            //建立一个数据库连接对象，不需要open
            conn = new SqlConnection("server=DESKTOP-RUSEPIQ;database=xsxk;uid=sa;pwd=123");
            //创建两个数据集
            DataSet ds = new DataSet();
            DataSet ds1 = new DataSet();

            //创建适配器sda并且从xk表中获取数据
            SqlDataAdapter sda = new SqlDataAdapter("select * from xk", conn);
            
            //将数据存入到数据集ds中
            sda.Fill(ds);

            //创建适配器sda并且从xk表中获取数据
            SqlDataAdapter sda1 = new SqlDataAdapter("select * from kc", conn);

            //用于将对 DataSet 所做的更改与关联的 SQL Server 数据库的更改相协调
            SqlCommandBuilder sbl = new SqlCommandBuilder(sda1);
            sda1.Fill(ds1);

            ds1.Merge(ds, true, MissingSchemaAction.AddWithKey);
            dataGridView1.DataSource = ds1.Tables[0];
        }
    }
}
