using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 高级控件
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            string path1="D:\\12345C#\\第十二章\\高级控件\\03.jpg";
            string path2 = "D:\\12345C#\\第十二章\\高级控件\\02.jpg";

            Image im1 = Image.FromFile(path1, true);
            imageList1.Images.Add(im1);

            Image im2 = Image.FromFile(path2, true);
            imageList1.Images.Add(im2);

            imageList1.ImageSize = new Size(256, 256);
            pictureBox1.Height = 256;
            pictureBox1.Width = 256;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            pictureBox1.Image = imageList1.Images[0];
            button1.Image = imageList1.Images[0];
        }

        private void button2_Click(object sender, EventArgs e)
        {
            pictureBox1.Image = imageList1.Images[1];
        }
    }
}
