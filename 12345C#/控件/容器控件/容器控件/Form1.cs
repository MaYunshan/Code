using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 容器控件
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            this.panel1.Visible = false;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if(textBox1.Text=="")
            {
                MessageBox.Show("请输入姓名");
                textBox1.Focus();
            }
            if(textBox1.Text.Trim()=="123")
            {
                this.panel1.Show();
            }
            else
            {
                MessageBox.Show("查无此人");
            }
        }
    }
}
