using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 列表视图
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if(textBox1.Text=="")
            {
                MessageBox.Show("项目不能为空");
            }
            else
            {
                listView1.Items.Add(textBox1.Text.Trim());
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            //listView1.View = View.Tile;        //平铺效果
            listView1.LargeImageList = imageList1;
            listView1.SmallImageList = imageList1;

            listView1.Items.Add("一生所爱");
            listView1.Items.Add("烟消云散");
            listView1.Items[0].ImageIndex = 0;
            listView1.Items[1].ImageIndex = 1;

        }
    }
}
