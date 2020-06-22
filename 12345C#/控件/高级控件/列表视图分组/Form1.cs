using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 列表视图分组
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            //设置listView的view属性，样式
            listView1.View = View.SmallIcon;


            listView1.LargeImageList = imageList1;
            listView1.SmallImageList = imageList1;

            //在listView里添加两个分组
            listView1.Groups.Add(new ListViewGroup("名称", HorizontalAlignment.Left));
            listView1.Groups.Add(new ListViewGroup("年龄", HorizontalAlignment.Left));

            //在控件里添加项目
            listView1.Items.Add("一生所爱");
            listView1.Items.Add("志同道合");
            listView1.Items.Add("风雨同舟");
            listView1.Items.Add("肝胆相照");
            listView1.Items.Add("生死相依");
            listView1.Items.Add("发奋图强");

            //为各个项目添加图片
            listView1.Items[0].ImageIndex = 0;
            listView1.Items[1].ImageIndex = 1;
            listView1.Items[2].ImageIndex = 2;
            listView1.Items[3].ImageIndex = 3;
            listView1.Items[4].ImageIndex = 4;
            listView1.Items[5].ImageIndex = 5;

            //项目分组
            listView1.Items[0].Group = listView1.Groups[0];
            listView1.Items[1].Group = listView1.Groups[0];
            listView1.Items[2].Group = listView1.Groups[0];

            listView1.Items[3].Group = listView1.Groups[1];
            listView1.Items[4].Group = listView1.Groups[1];
            listView1.Items[5].Group = listView1.Groups[1];
        }
    }
}
