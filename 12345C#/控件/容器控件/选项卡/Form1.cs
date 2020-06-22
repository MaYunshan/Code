using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 选项卡
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            tabControl1.ImageList = imageList1;
            tabPage1.ImageIndex = 0;
            tabPage1.Text = "选项卡1";
            tabPage2.ImageIndex = 0;
            tabPage2.Text = "选项卡2";
            Button btn1 = new Button();
            btn1.Text = "按钮2";
            tabPage2.Controls.Add(btn1);
        }
    }
}
