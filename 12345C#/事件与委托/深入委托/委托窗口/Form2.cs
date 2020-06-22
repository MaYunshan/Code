using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 委托窗口
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string str = this.textBox1.Text;

            //触发一个事件
            Middle.DoSomeMessage(str);
            textBox1.Clear();
            textBox1.Focus();
        }
    }
}
