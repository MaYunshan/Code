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

namespace 更新数据源
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        SqlConnection conn;
        SqlDataAdapter sda;
        DataSet ds;
        private void Form1_Load(object sender, EventArgs e)
        {
            //创建一个连接对象，有效就可以，但是不需要open
            conn = new SqlConnection("server=DESKTOP-RUSEPIQ;database=xsxk;uid=sa;pwd=123");

            SqlCommand cmd = new SqlCommand("select * from xk", conn);

            //实例化一个数据适配器对象，是dataset与数据源之间的桥梁
            sda = new SqlDataAdapter();
            //从数据库获得数据
            sda.SelectCommand = cmd;

            ds = new DataSet();
            //将获得的数据保存到dataset中
            sda.Fill(ds, "xk");

            //拿出dataset中的第一张表格
            dataGridView1.DataSource = ds.Tables[0];
        }

       

        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
         //将表中点击的某一行数据的详细信息显示
            txtId.Text = dataGridView1.SelectedCells[0].Value.ToString();
            txtCurse.Text = dataGridView1.SelectedCells[1].Value.ToString();
            txtGoal.Text = dataGridView1.SelectedCells[2].Value.ToString();
        }
    }
}
