using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 控件
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            this.AcceptButton = btn_open;
        }

        private void btn_open_Click(object sender, EventArgs e)
        {
            Form2 f2 = new Form2();
            f2.Show();
            this.Hide();
        }

        private void btn_open_MouseEnter(object sender, EventArgs e)
        {
            //btn_open.Hide();
        }

        private void btn_open_MouseLeave(object sender, EventArgs e)
        {
            btn_open.Show();
        }

        private void btn_open2_Click(object sender, EventArgs e)
        {
            Form3 f3 = new Form3();
            f3.Show();
        }

        private void btn_open4_Click(object sender, EventArgs e)
        {
            Form4 f4 = new Form4();
            f4.Show();
        }
    }
}
