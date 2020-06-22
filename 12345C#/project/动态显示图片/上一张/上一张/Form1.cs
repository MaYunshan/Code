using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace 上一张
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        //获取picture文件夹里的所有文件
        string[] path = Directory.GetFiles(@"D:\12345C#\project\动态显示图片\picture");
        int i=0;                       
        private void Form1_Load(object sender, EventArgs e)
        {
            pictureBox1.SizeMode = PictureBoxSizeMode.StretchImage;        //显示图片为平铺格式
            pictureBox1.Image = Image.FromFile(@"D:\12345C#\project\动态显示图片\picture\02.jpg");
        }

        /// <summary>
        /// 上一张
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void button1_Click(object sender, EventArgs e)
        {
            i--;
            if (i <0)
                i = path.Length-1;
            pictureBox1.Image = Image.FromFile(path[i]);
        }

        /// <summary>
        /// 下一张
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void button2_Click(object sender, EventArgs e)
        {
            i++;
            if (i >= path.Length)
                i = 0;
            pictureBox1.Image = Image.FromFile(path[i]);
        }

       
    }
}
