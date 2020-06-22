using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 按钮触发
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            ((Button)sender).Text = "click";
            Button newBtn = new Button();
            newBtn.Text = "buttonNew";
             
             //接着使用一些重载运算符语法，把这个事件处理程序注册为 Click 事件的监听程序。同时使用
            //非默认的构造函数创建一个新的EventHandler 对象，其名称是新事件处理函数的名称
           
            newBtn.Click += new EventHandler(newBtn_Click);
           
            //利用窗体的 Controls 属性，这个属性是一个对象，是窗体上所有控件的组合，通过它的
            //Add()方法把新按钮添加到窗体上：
           
            Controls.Add(newBtn);
        }

        private void newBtn_Click(object sender, EventArgs e)
        {
            ((Button)sender).Text = "clickNew";
        }
    }
}
