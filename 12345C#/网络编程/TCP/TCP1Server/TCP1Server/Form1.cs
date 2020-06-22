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

namespace TCP1Server
{

    public partial class Form1 : Form
    {


        private delegate void SetTextValueCallBack(string strValue);     //定义回调:解决跨线程访问问题
        private delegate void ReceiveMsgCallBack(string strReceive);     //定义接收客户端发送消息的回调
        private delegate void SetCmbCallBack(string strItem);           //定义回调：给ComboBox控件添加元素
        private delegate void SendFileCallBack(byte[] bf);              //定义发送文件的回调

        private SetTextValueCallBack setCallBack;        //声明回调
        private ReceiveMsgCallBack receiveCallBack;      //声明
        private SetCmbCallBack setCmbCallBack;           //声明
        private SendFileCallBack sendCallBack;           //声明
        
        Socket sock = null;                           //声明一个监听套接字的对象
        Socket server = null;                          //声明服务器通信套接字
        byte[] data = new byte[1024];                   //数据缓冲器

        //将远程连接的客户端的IP地址和Socket存入集合中
        //键是ip地址；值是socket
         Dictionary<string, Socket> dicSocket = new Dictionary<string, Socket>();


         Thread AcceptSocketThread;      //创建监听连接的线程
         Thread threadReceive;
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            this.ActiveControl = rtxtSend;
            //IPEndPoint ipep = new IPEndPoint(IPAddress.Parse("127.0.0.1"), 8888);
            //sock = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
            //sock.Bind(ipep);               //设置监听地址
            //sock.Listen(10);               //监听

            ////实例化回调
            //setCallBack = new SetTextValueCallBack(SetTextValue);
            //receiveCallBack = new ReceiveMsgCallBack(ReceiveMsg);
            //setCmbCallBack = new SetCmbCallBack(AddCmbItem);
            //sendCallBack = new SendFileCallBack(SendFile);

            ////创建线程
            //AcceptSocketThread = new Thread(new ParameterizedThreadStart(StartListen));
            //AcceptSocketThread.IsBackground = true;
            //AcceptSocketThread.Start(sock);

        }

        private void btnListen_Click(object sender, EventArgs e)
        {
            IPEndPoint ipep = new IPEndPoint(IPAddress.Parse("127.0.0.1"), 8888);
            sock = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
            sock.Bind(ipep);               //设置监听地址
            sock.Listen(10);               //监听

            //实例化回调
            setCallBack = new SetTextValueCallBack(SetTextValue);
            receiveCallBack = new ReceiveMsgCallBack(ReceiveMsg);
            setCmbCallBack = new SetCmbCallBack(AddCmbItem);
            sendCallBack = new SendFileCallBack(SendFile);

            //创建线程
            AcceptSocketThread = new Thread(new ParameterizedThreadStart(StartListen));
            AcceptSocketThread.IsBackground = true;
            AcceptSocketThread.Start(sock);
       
        }

        private void StartListen(object obj)
        {
            Socket sock = obj as Socket;
            while (true)
            {
                server = sock.Accept();   //等待客户端的连接，并创建新的套接字

                //获取远程主机的ip地址和端口号
                string strIp = server.RemoteEndPoint.ToString();

                dicSocket.Add(strIp, server);

                this.cmb_Socket.Invoke(setCmbCallBack, strIp);

                string str = string.Format("欢迎{0}的连接！", server.RemoteEndPoint.ToString());
                //使用回调函数
                //setCallBack(str);
                rtxtRecv.Invoke(setCallBack, str);

                //每当有一个新客户端连接时，创建一个单独的线程用来通信 (这里可能有问题)
                Thread threadReceive = new Thread(new ParameterizedThreadStart(Receive));
                threadReceive.IsBackground = true;
                threadReceive.Start(server);
            }
        }

        /// <summary>
        /// 服务器端不停的接收客户端发送的消息
        /// </summary>
        /// <param name="obj"></param>
        private void Receive(object obj)
        {
            Socket server = obj as Socket;
            while(true)
            {
                //客户端建立连接以后，服务器接收客户端的信息
                byte[] data = new byte[2048];
                int count = server.Receive(data);
                if (count == 0)
                    break;
                else
                {
                    string str = Encoding.Default.GetString(data);
                    string strReceiveMsg =Thread.CurrentThread.ManagedThreadId.ToString()+"接收:" + server.RemoteEndPoint.ToString() + "发送的消息:" + str;
                    this.rtxtRecv.Invoke(receiveCallBack, strReceiveMsg);
                }
            }
        }

        private void SendFile(byte[] bf)
        {
            try
            {
                dicSocket[cmb_Socket.SelectedItem.ToString()].Send(bf,SocketFlags.None); 
            }
            catch(Exception ex)
            {
                MessageBox.Show("发送文件出错:" + ex.Message);
            }
        }

        private void AddCmbItem(string strItem)
        {
            this.cmb_Socket.Items.Add(strItem);
        }

        private void ReceiveMsg(string strReceive)
        {
            this.rtxtRecv.AppendText(strReceive);
            this.rtxtRecv.AppendText("\r\n");
        }

        private void SetTextValue(string strValue)
        {
            this.rtxtRecv.AppendText(strValue + "\r\n");
        }

        /// <summary>
        /// 服务器给客户端发送信息
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnSend_Click(object sender, EventArgs e)
        {
            try
            {
                string str = this.rtxtSend.Text.Trim();
                byte[] data = Encoding.Default.GetBytes(str);
                List<byte> list = new List<byte>();
                list.Add(0);
                list.AddRange(data);
               
                byte[] newBuffer = list.ToArray();                      //将泛型集合转换为数组

                Console.WriteLine(newBuffer);
                string ip = this.cmb_Socket.SelectedItem.ToString();     //获得用户选择的IP地址
                int nSend=dicSocket[ip].Send(newBuffer);
                Console.WriteLine(nSend);
            }
            catch (Exception ex)
             {
                 MessageBox.Show("给客户端发送消息出错:"+ex.Message);
             }
        }
        
        /// <summary>
        /// 选择要发送的文件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnSelect_Click(object sender, EventArgs e)
        {
            OpenFileDialog dia = new OpenFileDialog();
            dia.InitialDirectory = @"";
            dia.Filter = "所有文件|*.*";
            dia.ShowDialog();

            this.txtFileName.Text = dia.FileName;
        }

        /// <summary>
        /// 发送文件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnSendFile_Click(object sender, EventArgs e)
        {
            List<byte> list = new List<byte>();

            string path = this.txtFileName.Text.Trim();

            using (FileStream sw = new FileStream(path, FileMode.Open, FileAccess.Read))
            {
                byte[] data = new byte[2048];
                int nRead = sw.Read(data, 0, data.Length);
                list.Add(1);
                list.AddRange(data);
                byte[] buffer = list.ToArray();

                this.Invoke(sendCallBack, buffer);
            }                                   
        }
        private void btnClose_Click(object sender, EventArgs e)
        {
            sock.Close();
            server.Close();
            AcceptSocketThread.Abort();
            //threadReceive.Abort();      
        }

       
    }
}
