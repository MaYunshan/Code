using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 绘制矩形
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Graphics ghs = this.CreateGraphics();					//创建Graphics对象
            Brush mybs = new SolidBrush(Color.Red);				//使用SolidBrush类创建一个Brush对象
            Rectangle rt = new Rectangle(10, 10, 100, 100);				//绘制一个矩形
            ghs.FillRectangle(mybs, rt);								//用Brush填充Rectangle
        }

    }
}
