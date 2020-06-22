using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Net;
using System.Net.Sockets;
using System.Threading;
using System.IO;

namespace TCP1Client
{
    public partial class Form1 : Form
    {
        private delegate void SetTextCallBack(string strValue);     //用于在线程间传递字符串的委托
        private delegate void ReceiveMsgCallBack(string strMsg);    //接收信息的委托
        private SetTextCallBack setCallBack;                       //委托声明
        private ReceiveMsgCallBack receiveCallBack;                  //声明

        Socket client = null;           //声明一个客服端的socket对象 

        Thread thReceive = null;        //单独一个线程用来读取信息
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            this.ActiveControl = txtPort;
        }

        private void btnConnect_Click(object sender, EventArgs e)
        {
            try
            {
                //实例一个socket对象
                client = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
                IPAddress ip = IPAddress.Parse(txtIp.Text);
                int port = Convert.ToInt32(txtPort.Text);

                IPEndPoint ie = new IPEndPoint(ip, port);
                client.Connect(ie);


                setCallBack = setValue;
                receiveCallBack =receiveData;

                this.rtxtRecv.Invoke(setCallBack, "已经成功连接到服务器！");

                thReceive = new Thread(new ThreadStart(Receive));
                thReceive.IsBackground = true;
                thReceive.Start();
            }
           catch(Exception ex)
            {
                MessageBox.Show("连接服务器时出错：" + ex.ToString());
            }
        }

        private void receiveData(string strMsg)
        {
            this.rtxtRecv.AppendText(strMsg + "\r\n");
        }

        private void Receive()
        {
            try
            {
                while(true)
                {
                    byte[] data = new byte[2048];
                    int nRead = client.Receive(data);
                    
                    Console.WriteLine(nRead);
                    for (int i = 0; i < nRead; i++)
                        Console.Write(data[i] + " ");
                        if (nRead == 0)
                            break;
                        else
                        {
                            //判断发送类型
                            if (data[0] == 0)     //表示发送的是文字信息
                            {
                                string str = Encoding.Default.GetString(data,1,nRead-1);
                                Console.WriteLine(str);
                                string strDis = "接收远程服务器:" + client.RemoteEndPoint + "发送的消息:" + str;
                                this.rtxtRecv.Invoke(receiveCallBack, strDis);
                            }

                            if (data[0] == 1)     //表示发送的是文件
                            {
                                SaveFileDialog sfd = new SaveFileDialog();
                                sfd.InitialDirectory = @"";
                                sfd.Title = "请选择要保存的文件";
                                sfd.Filter = "所有文件|*.*";
                                sfd.ShowDialog(this);

                                string strPath = sfd.FileName;
                                using (FileStream fsWrite = new FileStream(strPath, FileMode.OpenOrCreate, FileAccess.Write))
                                {
                                    fsWrite.Write(data, 1, nRead - 1);
                                }
                                MessageBox.Show("保存文件成功");
                            }
                        }
                }
            }
            catch(Exception ex)
            {
                MessageBox.Show("接收服务器的信息时出错" + ex.ToString());
            }
        }

        private void setValue(string strValue)
        {
            this.rtxtRecv.AppendText(strValue + "\r\n");
        }

        /// <summary>
        /// 客户端给服务器发送信息
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                string strMsg = this.rtxtSend.Text.Trim();
                byte[] data = new byte[2048];
                data = Encoding.Default.GetBytes(strMsg);
                int nSend = client.Send(data);
            }
            catch(Exception ex)
            {
                MessageBox.Show("发送信息时出错" + ex.ToString());
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
             //关闭socket
             client.Close();
             //终止线程
             thReceive.Abort();
        }
    }
}
