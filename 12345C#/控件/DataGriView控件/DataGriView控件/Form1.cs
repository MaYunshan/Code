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

namespace DataGriView控件
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        SqlConnection conn;
        SqlDataAdapter sda;
        DataSet ds = null;
        private void Form1_Load(object sender, EventArgs e)
        {
            conn = new SqlConnection("server=DESKTOP-RUSEPIQ;database=xsxk;uid=sa;pwd=123");
            sda = new SqlDataAdapter("select * from kc", conn);
            ds = new DataSet();
            sda.Fill(ds, "kc");
            dataGridView1.DataSource = ds.Tables[0];
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string msg = String.Format("第{0}行,第{1}列", dataGridView1.CurrentCell.RowIndex,
                        dataGridView1.CurrentCell.ColumnIndex);
            label1.Text = "选择的单元格为：" + msg;
        }
    }
}
