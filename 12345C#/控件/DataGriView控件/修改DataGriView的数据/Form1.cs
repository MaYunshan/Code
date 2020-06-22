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

namespace 修改DataGriView的数据
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        SqlConnection conn;
        SqlDataAdapter asapter;
        private void button2_Click(object sender, EventArgs e)
        {
            conn = new SqlConnection("server=DESKTOP-RUSEPIQ;database=xsxk;uid=sa;pwd=123");
            SqlDataAdapter sda = new SqlDataAdapter("select * from kc", conn);
            DataSet ds = new DataSet();
            sda.Fill(ds);
            dataGridView1.DataSource = ds.Tables[0];

            //禁止显示行标题
            dataGridView1.RowHeadersVisible = false;

            for(int i=0;i<dataGridView1.ColumnCount;i++)
            {
                dataGridView1.Columns[i].Width = 84;
            }

            button2.Enabled = false;
            dataGridView1.Columns[0].ReadOnly = true;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if(dbUpate())
            {
                MessageBox.Show("修改成功！");
            }
        }

        private bool dbUpate()
        {
            string strSql = "select * from kc";
            DataTable dtUpate = new DataTable();
            dtUpate = this.dbconn(strSql);
            dtUpate.Rows.Clear();
            DataTable dtShow = new DataTable();
            dtShow = (DataTable)this.dataGridView1.DataSource;
            for(int i=0;i<dtShow.Rows.Count;i++)
            {
                dtUpate.ImportRow(dtShow.Rows[i]);
            }

            try
            {
                this.conn.Open();
                SqlCommandBuilder CommandBuilder = new SqlCommandBuilder(this.asapter);
                this.asapter.Update(dtUpate);
                this.conn.Close();
            }

            catch(Exception ex)
            {
                MessageBox.Show(ex.Message.ToString());
                return false;
            }

            dtUpate.AcceptChanges();
            return true;
        }

        private DataTable dbconn(string strSql)
        {
            //conn.Open();
            //重新获取一张查询表，将它的数据删除，只保留结构，用于容纳修改后的数据
            this.asapter = new SqlDataAdapter(strSql, conn);
            DataTable dtSelect = new DataTable();
            int rnt = this.asapter.Fill(dtSelect);
            conn.Close();
            return dtSelect;
        }
    }
}
