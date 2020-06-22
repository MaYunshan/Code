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

namespace DataGriView选中行变色
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

            dataGridView1.SelectionMode = DataGridViewSelectionMode.FullRowSelect;

            dataGridView1.ReadOnly = true;

            dataGridView1.DefaultCellStyle.SelectionBackColor = Color.Red;
        }
    }
}
