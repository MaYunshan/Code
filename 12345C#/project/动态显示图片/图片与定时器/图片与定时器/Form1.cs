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
using System.Media;

namespace 图片与定时器
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        //获取picture文件夹里的所有文件
        string[] path = Directory.GetFiles(@"D:\12345C#\project\动态显示图片\picture");
        int i = 0;  
        private void Form1_Load(object sender, EventArgs e)
        {
            //SoundPlayer sp = new SoundPlayer();
            //sp.SoundLocation = @"E:\KuGou\Lyric\香香 - 学不会";
            //sp.Play();

            pictureBox1.SizeMode = PictureBoxSizeMode.StretchImage;        //显示图片为平铺格式
            pictureBox2.SizeMode = PictureBoxSizeMode.StretchImage;        //显示图片为平铺格式
            pictureBox3.SizeMode = PictureBoxSizeMode.StretchImage;        //显示图片为平铺格式
            pictureBox4.SizeMode = PictureBoxSizeMode.StretchImage;        //显示图片为平铺格式
            pictureBox5.SizeMode = PictureBoxSizeMode.StretchImage;        //显示图片为平铺格式
            pictureBox6.SizeMode = PictureBoxSizeMode.StretchImage;        //显示图片为平铺格式

            pictureBox1.Image = Image.FromFile(@"D:\12345C#\project\动态显示图片\picture\02.jpg");
            pictureBox2.Image = Image.FromFile(@"D:\12345C#\project\动态显示图片\picture\02.jpg");
            pictureBox3.Image = Image.FromFile(@"D:\12345C#\project\动态显示图片\picture\02.jpg");
            pictureBox4.Image = Image.FromFile(@"D:\12345C#\project\动态显示图片\picture\02.jpg");
            pictureBox5.Image = Image.FromFile(@"D:\12345C#\project\动态显示图片\picture\02.jpg");
            pictureBox6.Image = Image.FromFile(@"D:\12345C#\project\动态显示图片\picture\02.jpg");
           
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            i++;
            if (i >= path.Length)
                i = 0;
            pictureBox1.Image = Image.FromFile(path[i]);
            pictureBox2.Image = Image.FromFile(path[i]);
            pictureBox3.Image = Image.FromFile(path[i]);
            pictureBox4.Image = Image.FromFile(path[i]);
            pictureBox5.Image = Image.FromFile(path[i]);
            pictureBox6.Image = Image.FromFile(path[i]);
        }
    }
}
