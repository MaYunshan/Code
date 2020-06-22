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
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void Form2_Load(object sender, EventArgs e)
        {
            txt_read.ReadOnly = true;
            txt_read.Multiline = true;
            txt_read.Text = "涉江采芙蓉，兰泽多芳草。采之欲遗谁，所思在远道。还顾望旧乡，长路漫浩浩。同心而离居，忧伤以终老。";
        }
    }
}
