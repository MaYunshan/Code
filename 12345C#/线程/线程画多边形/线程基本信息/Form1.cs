using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Threading;

namespace 线程基本信息
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            string strInfo = string.Empty;

            Thread myThread = new Thread(new ThreadStart(threadOut));

            myThread.Start();

            //获取线程的相关信息
            strInfo = "线程标识符: " + myThread.ManagedThreadId;
            strInfo += "\n线程名称：" + myThread.Name;
            strInfo += "\n线程状态：" + myThread.ThreadState.ToString();
            strInfo += "\n线程优先级：" + myThread.Priority.ToString();
            strInfo += "\n是否为后台线程：" + myThread.IsBackground;

            Thread.Sleep(1000);

            myThread.Abort("退出");

            myThread.Join();             //通过主线程阻止其它新开线程，此线程未结束之前其它线程不能运行 

            MessageBox.Show("线程运行结束");
            richTextBox1.Text = strInfo;
        }

        private void threadOut()
        {
            MessageBox.Show("主线程开始运行");
        }
    }
}
