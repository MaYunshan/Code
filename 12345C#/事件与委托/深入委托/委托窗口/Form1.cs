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
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            
            //将委托与事件绑定
            Middle.sendEvent+=new Middle.SendMessage(this.DoMessage);
        }

        //事件触发后调用的方法
        public void DoMessage(string s)
        {
            this.listBox1.Items.Add(s);
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Form2 fChild = new Form2();
            fChild.Show();
        }
    }
}
