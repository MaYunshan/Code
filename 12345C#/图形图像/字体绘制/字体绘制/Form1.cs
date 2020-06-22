using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 字体绘制
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        protected override void OnPaint(PaintEventArgs e)
        {
            base.OnPaint(e);

            Graphics ghs = this.CreateGraphics();
            Font font = new Font("宋体", 16,FontStyle.Bold | FontStyle.Strikeout|FontStyle.Underline, GraphicsUnit.Point);
            ghs.DrawString("图形图形技术", font,Brushes.LightPink, new Point(20, 20));

            this.button1.Font = font;
            SizeF sizefont = e.Graphics.MeasureString(button1.Text, font);
            button1.Size = new Size((int)sizefont.Width,(int)sizefont.Height+2);
            this.label1.Text = font.Style.ToString();
            this.label2.Text = font.Unit.ToString();

        }
    }
}
