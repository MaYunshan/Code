using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Drawing.Imaging;

namespace 图片格式
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Graphics ghs = this.CreateGraphics();
            Image img = Image.FromFile(@"D:\12345C#\picture\1.wmf");
            ghs.DrawImage(img,0,0,500,574);
            this.label1.Text = img.PixelFormat.ToString();
            //img.RotateFlip(RotateFlipType.Rotate180FlipNone);
            ghs.Dispose();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Graphics ghs = this.CreateGraphics();
            ghs.Clear(BackColor);
            ghs.Dispose();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Graphics ghs = this.CreateGraphics();
            Bitmap bmap = new Bitmap(@"D:\12345C#\picture\红色.jpg");
            ghs.DrawImage(bmap, 0, 0, 300, 300);
            bmap.Save(@"D:\12345C#\picture\红色1.jpg");
            ghs.Dispose();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            Graphics ghs = this.CreateGraphics();
            Metafile bmap = new Metafile(@"E:\BaiduNetdiskDownload\PPT\[矢量图库王].001-010\001-010\001\0001-0500\TP0001");
            ghs.DrawImage(bmap, 0, 0, 600, 500);
            ghs.Dispose();
        }
    }
}
