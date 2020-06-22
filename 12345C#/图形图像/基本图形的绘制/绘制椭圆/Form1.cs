using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Drawing.Drawing2D;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 绘制椭圆
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Line_Click(object sender, EventArgs e)
        {
            Pen pen1 = new Pen(Color.Red, 5);
            Point p1 = new Point(10, 50);
            Point p2 = new Point(200, 50);
            Graphics ghs = this.CreateGraphics();
            ghs.DrawLine(pen1, p1, p2);
            ghs.Dispose();
            pen1.Dispose();
        }

        private void Clear_Click(object sender, EventArgs e)
        {
            Graphics ghs = this.CreateGraphics();
            ghs.Clear(Color.White);
            ghs.Dispose();
        }

        private void Ellipse_Click(object sender, EventArgs e)
        {
            Graphics ghs = this.CreateGraphics();
            //SolidBrush brush1 = new SolidBrush(Color.Green);
            ghs.FillEllipse(brush, 50, 60, 260, 100);
            ghs.Dispose();
        }

        private void groupBox1_Paint(object sender, PaintEventArgs e)
        {
            e.Graphics.Clear(groupBox1.BackColor);
            SizeF fontSize = e.Graphics.MeasureString(groupBox1.Text, groupBox1.Font);
            Console.WriteLine(groupBox1.Text);
            e.Graphics.DrawString(groupBox1.Text, groupBox1.Font, Brushes.MediumBlue, (groupBox1.Width - fontSize.Width) / 2, 1);
            e.Graphics.DrawLine(Pens.MediumBlue, 1, 10, (groupBox1.Width - fontSize.Width) / 2, 10);
            e.Graphics.DrawLine(Pens.MediumBlue, (groupBox1.Width + fontSize.Width) / 2 - 4, 10, groupBox1.Width - 2, 10);
        }

        private Brush brush = new SolidBrush(Color.Red);
        private void radioButton1_CheckedChanged(object sender, EventArgs e)
        {
            brush = new SolidBrush(Color.Green);
        }

        private void radioButton2_CheckedChanged(object sender, EventArgs e)
        {
            brush = new TextureBrush(imageList1.Images[0]);
        }

        private void radioButton3_CheckedChanged(object sender, EventArgs e)
        {
            //渐变。从一种颜色到另外一种颜色的渐变
            Point startPt = new Point(50, 60);
            Point endPt = new Point(310, 60);
            brush = new LinearGradientBrush(startPt, endPt, Color.Green, Color.Red);
        }

        private void radioButton4_CheckedChanged(object sender, EventArgs e)
        {
            brush = new HatchBrush(HatchStyle.ForwardDiagonal, Color.Red, Color.LightBlue);
        }

        private void star_Click(object sender, EventArgs e)
        {
            Point[] pt = new Point[10];
            pt[0] = new Point(120, 46);
            pt[1] = new Point(156, 46);
            pt[2] = new Point(168, 10);
            pt[3] = new Point(180, 46);
            pt[4] = new Point(214, 46);
            pt[5] = new Point(188, 70);
            pt[6] = new Point(198, 106);
            pt[7] = new Point(168, 82);
            pt[8] = new Point(138, 104);
            pt[9] = new Point(150, 70);

            GraphicsPath path = new GraphicsPath();
            for (int i = 0; i <= 8; i++)
                path.AddLine(pt[i], pt[i + 1]);
             path.CloseFigure();

            Graphics ghs = this.CreateGraphics();
            ghs.FillPath(brush, path);
            ghs.Dispose();
            path.Dispose();
        }
    }
}
