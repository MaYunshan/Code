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

namespace DataGridView中添加数据
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // 指定DataGridView控件显示的列数
            dataGridView1.ColumnCount = 4;
            dataGridView1.ColumnHeadersVisible = true;

            dataGridView1.RowHeadersVisible = false;
            // 设置DataGridView控件标题列的样式
            DataGridViewCellStyle columnHeaderStyle = new DataGridViewCellStyle();
            columnHeaderStyle.BackColor = Color.Beige;
            columnHeaderStyle.Font = new Font("Verdana", 10, FontStyle.Bold);
            dataGridView1.ColumnHeadersDefaultCellStyle = columnHeaderStyle;

            dataGridView1.Columns[0].Name = "编号";
            dataGridView1.Columns[1].Name = "姓名";
            dataGridView1.Columns[2].Name = "年龄";
            dataGridView1.Columns[3].Name = "性别";

            string[] row1 = new string[] { "0001", "小吕", "28", "男" };
            string[] row2 = new string[] { "0002", "小张", "27", "男" };
            string[] row3 = new string[] { "0003", "小郭", "24", "女" };
            string[] row4 = new string[] { "0004", "小贯", "21", "女" };
            string[] row5 = new string[] { "0005", "小陈", "20", "女" };
            string[] row6 = new string[] { "0006", "小梁", "23", "男" };

            object[] rows = new object[] { row1, row2, row3, row4, row5, row6 };
            foreach (string[] rowArray in rows)
            {
                dataGridView1.Rows.Add(rowArray);
            }

            //一个下拉列表，另外一个程序
            //DataGridViewComboBoxColumn comboboxColumn = new DataGridViewComboBoxColumn();
            //comboboxColumn.Name = "学生编号";
            //this.dataGridView1.Columns.Add(comboboxColumn);
            //SqlConnection con = new SqlConnection("server=DESKTOP-RUSEPIQ;database=xsxk;uid=sa;pwd=123");
            //con.Open();
            //SqlCommand com = new SqlCommand("select * from kc", con);
            //SqlDataReader dr = com.ExecuteReader();
            //while (dr.Read())
            //{
            //    comboboxColumn.Items.Add(dr[0].ToString());
            //}
            //dr.Close();
            //con.Close();
        }
    }
}
