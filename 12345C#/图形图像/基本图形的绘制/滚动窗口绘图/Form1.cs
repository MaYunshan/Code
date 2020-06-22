using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 滚动窗口绘图
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            this.BackColor = Color.White;
            this.AutoScrollMinSize=new Size(300, 250);
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        protected override void OnPaint(PaintEventArgs e)
        {
            base.OnPaint(e);

            Graphics ghs = e.Graphics;
            label1.Text = this.AutoScrollPosition.X.ToString();
            label2.Text = this.AutoScrollPosition.Y.ToString();

            ghs.TranslateTransform(this.AutoScrollPosition.X, this.AutoScrollPosition.Y);
            ghs.FillRectangle(Brushes.LightPink, 0, 0, 200, 150);
            ghs.FillEllipse(Brushes.LightSteelBlue, 0, 150, 300, 100);
        }
    }
}
