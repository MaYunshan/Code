using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 使用委托写入文本
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        //1.定义委托
        public delegate void WriteToText(string str);

        //2.声明委托
        WriteToText WriteCallBack;


        /// <summary>
        /// 提交作业
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void submit_Click(object sender, EventArgs e)
        {
            try
            {
                if(chbOne.Checked)
                {
                    gb_text1.Text = "运行中......";
                    gb_text1.Refresh();
                    //txtTask1.Clear();

                    //实例化一个委托
                    //WriteCallBack = new WriteToText(WriteTask1);
                    WriteCallBack = WriteTask1;

                    //将委托作为方法的参数进行传递
                    WriteTask(WriteTask1);
                    gb_text1.Text = "作业1提交";
                }
                if(chbTwo.Checked)
                {
                    gb_text2.Text = "运行中......";
                    gb_text2.Refresh();
                    //txtTask2.Clear();

                    WriteCallBack = new WriteToText(WriteTask2);
                    //WriteCallBack = WriteTask2;
                    WriteTask(WriteTask2);
                    gb_text1.Text = "作业2提交";
                }
            }
            catch(Exception ex)
            {
                MessageBox.Show("提交作业失败:" + ex.ToString());
            }
        }

        private void WriteTask2(string str)
        {
            this.txtTask2.AppendText(str + "\r\n");
        }

        private void WriteTask(WriteToText WriteTask)
        {
            string str = this.txtTask.Text;
            WriteTask(str);
        }

        private void WriteTask1(string str)
        {
            this.txtTask1.AppendText(str + "\r\n");
        }



       
    }
}
