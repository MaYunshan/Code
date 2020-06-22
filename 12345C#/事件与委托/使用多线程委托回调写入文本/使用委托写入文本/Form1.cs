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

namespace 使用委托写入文本
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        //1.定义委托
        public delegate void WriteToText(string str);       //向文本区写入内容的委托
        public delegate void WriteToGroup(string str);       //向分组框写入内容的委托
        public delegate void WriteToJob(string str);       //向文本区写入内容的委托
        
        //2.声明委托
        WriteToText WriteCallBack;
        WriteToGroup WriteGroupCallBack;
        WriteToJob WriteToJobCallBack;

        /// <summary>
        /// 提交作业
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void submit_Click(object sender, EventArgs e)
        {
            try
            {
                Thread th1 = new Thread(new ThreadStart(ExecuteOne));
                th1.Start();

                Thread th2 = new Thread(new ThreadStart(ExecuteTwo));
                th2.Start();
               
                
            }
            catch(Exception ex)
            {
                MessageBox.Show("提交作业失败:" + ex.ToString());
            }
        }

        private void ExecuteOne()
        {
            if (chbOne.Checked)
            {
                WriteGroupCallBack = WriteGroup1;
                this.gb_text1.Invoke(WriteGroupCallBack, "运行中......");
                

                //实例化一个委托

                WriteCallBack = new WriteToText(WriteTask1);
                WriteToJobCallBack = new WriteToJob(WriteOneJob);

                //将委托作为方法的参数进行传递
                WriteTask(WriteCallBack);

                this.gb_text1.Invoke(WriteGroupCallBack, "作业1提交");

            }
        }

        private void ExecuteTwo()
        {
            if (chbTwo.Checked)
            {
                WriteGroupCallBack=WriteGroup2;

                this.gb_text2.Invoke(WriteGroupCallBack, "运行中......");

                WriteCallBack = new WriteToText(WriteTask2);
                WriteToJobCallBack = new WriteToJob(WriteOneJob);

                WriteTask(WriteCallBack);
               
                this.gb_text2.Invoke(WriteGroupCallBack, "作业2提交");
            }
        }

        private void WriteTask2(string str)
        {
            this.txtTask2.Invoke(WriteToJobCallBack, str);
        }

        private void WriteTask(WriteToText WriteTask)
        {
            string str = this.txtTask.Text;
            WriteTask(str);
        }

        private void WriteTask1(string str)
        {
            this.txtTask1.Invoke(WriteToJobCallBack, str);
                 
        }
        private void WriteOneJob(string str)
        {
            this.txtTask1.AppendText(str + "\r\n");
        }
        private void WriteTwoJob(string str)
        {
            this.txtTask2.AppendText(str + "\r\n");
        }


        private void WriteGroup(WriteToGroup writeGroup)
        {
            string str = this.txtTask.Text;
            writeGroup(str);
        }

        private void WriteGroup1(string str)
        {
            this.gb_text1.Text = str;
            gb_text2.Refresh();
        }
        private void WriteGroup2(string str)
        {
            this.gb_text2.Text = str;
            gb_text2.Refresh();
        }


        private void Form1_Load(object sender, EventArgs e)
        {
            //设置文本框获取焦点
             this.ActiveControl = this.txtTask;
             //允许跨线程调用
             //Control.CheckForIllegalCrossThreadCalls = false;
        }





       
    }
}
