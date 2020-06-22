using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO.Ports;
using System.Text.RegularExpressions;
using System.IO;

namespace 串口1
{
    public partial class Form1 : Form
    {
        String strRecv;            //接收字符串
        String strSend;            //发送字符串
        int nRecv_count = 0;                   //接收字节数
        int nSend_count = 0;                   //发送字节数
        string strFileSavePath;            //数据保存文件夹
        string strFileSendPath;            //数据发送文件夹

        SerialPort sp;                   //通信串口
        Timer timerLoop;                    //数据循环发送

        public delegate void RecvDisplayHandler(byte[] buf);     //接收信息显示的委托

        RecvDisplayHandler RecvCallBack;

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            Control.CheckForIllegalCrossThreadCalls = false;             //可以跨线程使用
            sp = new SerialPort();
            timerLoop = new Timer();

            string[] ports = SerialPort.GetPortNames();                  //获取电脑上所有串口
            Array.Sort(ports);
            cmb_port.Items.AddRange(ports);                             //将串口全部添加到下拉框中
            cmb_port.SelectedIndex = cmb_port.Items.Count > 0 ? 0 : -1;   //默认选项

            sp.DataReceived += new SerialDataReceivedEventHandler(RecvData);   //注册事件，当串口接收到数据时触发
            RecvCallBack = new RecvDisplayHandler(RecvDisplay);
            timerLoop.Tick += new EventHandler(LoopSend);
        }

        private void RecvDisplay(byte[] buf)
        {
            strRecv = Algorithm.BytesToString(buf, Enum16进制隔离符.无);
            //string str = Encoding.Default.GetString(buf);


            if (chb_toHexRecv.Checked)              //转换为十六进制 
            {
                strRecv = Algorithm.StringTo16(strRecv, Enum16进制隔离符.空格);
            }

            if (chb_time.Checked)                  //显示时间
            {
                strRecv = "\r\n" + DateTime.Now.ToString("[yyyy-MM-dd hh:mm:ss.fff] ") + strRecv;
            }

            if (chb_pause.Checked)                  //暂停显示
            {
                strRecv = string.Empty;
            }

            if (chb_toFile.Checked)                //接收转向文件
            {
                using (StreamWriter sWriter = new StreamWriter(strFileSavePath, true))
                {
                    sWriter.WriteLine(strRecv);
                }
            }
            else                                //不转向文件，在接收区显示
            {
                this.rtxt_recv.AppendText(strRecv);
            }



        }

        private void RecvData(object sender, SerialDataReceivedEventArgs e)
        {
            int nRead = sp.BytesToRead;
            byte[] recv = new byte[nRead];
            nRecv_count += nRead;
            sp.Read(recv, 0, nRead);
            this.rtxt_recv.Invoke(RecvCallBack, recv);
            this.lab__recvCount.Text = "发送:" + nRecv_count;
        }

        /// <summary>
        /// 打开串口
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btn_openPort_Click(object sender, EventArgs e)
        {
            try
            {
                if (btn_openPort.Text == "关闭")
                {
                    sp.Close();
                    btn_openPort.Text = "打开";
                    pictureBox1.BackColor = Color.Red;
                }
                else
                {
                    sp.Open();
                    if (sp.IsOpen == true)
                    {
                        btn_openPort.Text = "关闭";
                        pictureBox1.BackColor = Color.Green;
                    }
                    else
                    {
                        btn_openPort.Text = "打开";
                        pictureBox1.BackColor = Color.Red;
                        MessageBox.Show("端口不存在或被占用！", "提示");
                    }
                }
            }
            catch (IOException)  //串口不存在异常
            {
                pictureBox1.BackColor = Color.Red;
                btn_openPort.Text = "打开";
            }
            catch (UnauthorizedAccessException)  //串口资源占用异常
            {
                pictureBox1.BackColor = Color.Red;
                btn_openPort.Text = "打开";
            }

        }


        #region 串口参数设置
        private void cmb_port_SelectedIndexChanged(object sender, EventArgs e)
        {
            sp.PortName = cmb_port.Text;
        }

        private void cmb_baud_SelectedIndexChanged(object sender, EventArgs e)
        {
            sp.BaudRate = Convert.ToInt32(cmb_baud.Text);
        }

        private void cmb_checkBit_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (cmb_checkBit.Text == "NONE")
                sp.Parity = Parity.None;
            else if (cmb_checkBit.Text == "ODD")
                sp.Parity = Parity.Odd;
            else if (cmb_checkBit.Text == "EVEN")
                sp.Parity = Parity.Even;
            else if (cmb_checkBit.Text == "MARK")
                sp.Parity = Parity.Mark;
            else
                sp.Parity = Parity.Space;
        }

        private void cmb_dataBit_SelectedIndexChanged(object sender, EventArgs e)
        {
            sp.DataBits = Convert.ToInt32(cmb_dataBit.Text);
        }

        private void cmb_stopBit_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (cmb_stopBit.Text == "1")
                sp.StopBits = StopBits.One;
            else if (cmb_stopBit.Text == "2")
                sp.StopBits = StopBits.Two;
        }
        #endregion

        private void chb_toFile_Click(object sender, EventArgs e)    //接收转向文件
        {
            if (chb_toFile.Checked == true)
            {
                SaveFileDialog sfd = new SaveFileDialog();
                sfd.ShowDialog();
                strFileSavePath = sfd.FileName;
                if (strFileSavePath == string.Empty)
                {
                    chb_toFile.Checked = false;
                }
                else
                {
                    this.rtxt_recv.AppendText(strFileSavePath + "\r\n");
                    this .rtxt_recv.BackColor = Form1.DefaultBackColor;
                }
            }
        }

        //发送文件复选框
        private void chb_sendFile_Click(object sender, EventArgs e)
        {
            if (chb_sendFile.Checked == true)
            {
                OpenFileDialog ofd = new OpenFileDialog();
                ofd.InitialDirectory = @"";
                ofd.Filter = "所有文件|*.*";
                ofd.ShowDialog();

                strFileSendPath = ofd.FileName;
                if (strFileSendPath == string.Empty)
                {
                    this.btn_send.Text = "发送数据";
                    chb_sendFile.Checked = false;
                }
                else
                {
                    this.rtxt_send.Text = strFileSendPath + "\r\n";
                    this.btn_send.Text = "发送文本";
                    this.rtxt_send.BackColor = Form1.DefaultBackColor;
                }

            }
            else
            {
                this.btn_send.Text = "发送数据";
                this.rtxt_send.Text = "";
                this.rtxt_send.BackColor = Color.White;
            }
        }

        //接收暂停事件
        private void chb_pause_Click(object sender, EventArgs e)
        {
            if (chb_pause.Checked == true)
            {
                this.rtxt_recv.BackColor = Color.Gray;
                this.rtxt_recv.ReadOnly = true;
            }
            else
            {
                this.rtxt_recv.BackColor = Color.White;
                this.rtxt_recv.ReadOnly = false;
            }
        }

        //将接收区的数据保存到文件中
        private void btn_saveData_Click(object sender, EventArgs e)
        {
            SaveFileDialog sfd = new SaveFileDialog();
            sfd.ShowDialog();
            if (sfd.FileName == string.Empty)
            {
                MessageBox.Show("请选择目的文件！");
            }
            else
            {
                string str = this.rtxt_recv.Text;
                Console.Write(str);
                using (StreamWriter sWriter = new StreamWriter(sfd.FileName, true))
                {
                    char strsPlit = '\n';
                    string[] strWriter = str.Split(strsPlit);      //按照回车符号分割并依此写入文件
                    foreach (string s in strWriter)
                        sWriter.WriteLine(s);
                }
            }
        }

        //从文件中加载数据
        private void btn_loadData_Click(object sender, EventArgs e)
        {
            OpenFileDialog ofd = new OpenFileDialog();
            ofd.InitialDirectory = @"";
            ofd.Filter = "所有文件|*.*";
            ofd.ShowDialog();
            if (ofd.FileName != string.Empty)
            {
                this.rtxt_send.Clear();
                using (FileStream fs = new FileStream(ofd.FileName, FileMode.Open, FileAccess.Read))
                {
                    byte[] data = new byte[fs.Length];
                    int nRead = fs.Read(data, 0, data.Length);
                    if (nRead >= 0)
                    {
                        string str = Encoding.Default.GetString(data);
                        this.rtxt_send.Text = str;
                    }
                }
            }
        }

        #region 清除文本区的按钮
        //清除接收区显示
        private void btn_clearDis_Click(object sender, EventArgs e)
        {
            this.rtxt_recv.Clear();
            nRecv_count = 0;
            this.lab__recvCount.Text = "接收:0";
        }

        //清除发送区显示
        private void btn_clearInput_Click(object sender, EventArgs e)
        {
            this.rtxt_send.Clear();
            nSend_count = 0;
            this.lab_sendCount.Text = "发送:0";
        }
        #endregion

        #region 鼠标进入清除显示按钮范围内变色
        //清除显示按钮
        private void btn_clearDis_MouseEnter(object sender, EventArgs e)
        {
            this.btn_clearDis.ForeColor = Color.Red;
        }

        private void btn_clearDis_MouseLeave(object sender, EventArgs e)
        {
            this.btn_clearDis.ForeColor = Color.SlateBlue;
        }

        //保存数据按钮
        private void btn_saveData_MouseEnter(object sender, EventArgs e)
        {
            this.btn_saveData.ForeColor = Color.Red;
        }

        private void btn_saveData_MouseLeave(object sender, EventArgs e)
        {
            this.btn_saveData.ForeColor = Color.SlateBlue;
        }

        //载入数据按钮
        private void btn_loadData_MouseEnter(object sender, EventArgs e)
        {
            this.btn_loadData.ForeColor = Color.Red;
        }

        private void btn_loadData_MouseLeave(object sender, EventArgs e)
        {
            this.btn_loadData.ForeColor = Color.SlateBlue;
        }

        //清除显示按钮
        private void btn_clearInput_MouseEnter(object sender, EventArgs e)
        {
            this.btn_clearInput.ForeColor = Color.Red;
        }

        private void btn_clearInput_MouseLeave(object sender, EventArgs e)
        {
            this.btn_clearInput.ForeColor = Color.SlateBlue;
        }

        #endregion

        #region 计数复位按钮
        //接收复位
        private void btn_recvCountReset_Click(object sender, EventArgs e)
        {
            nRecv_count = 0;
            this.lab__recvCount.Text = "接收:0";
        }

        //发送复位
        private void btn_sendCountReset_Click(object sender, EventArgs e)
        {
            nSend_count = 0;
            this.lab_sendCount.Text = "发送:0";
        }
        #endregion

        /// <summary>
        /// 发送
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btn_send_Click(object sender, EventArgs e)
        {
            if (this.rtxt_send.Text == string.Empty)
            {
                MessageBox.Show("请输入发送内容");
            }
            else
            {
                if(chb_loopSend.Checked)
                {
                    if(btn_send.Text=="发送"||btn_send.Text=="发送文本")
                    {
                        btn_send.Text = "停止发送";
                        timerLoop.Start();
                    }
                    else  //(btn_send.Text == "停止发送")
                    {
                        timerLoop.Stop();
                        btn_send.Text = "发送";
                    }                  
                }
                Send();
            }
        }

        private void Send()
        {
            if (chb_sendFile.Checked)        //如果发送的是文件数据 
            {
                //先获取文件路径
                string path = this.rtxt_send.Text.Trim();
                StreamReader sr = new StreamReader(path);
                strSend = sr.ReadToEnd();
            }
            else                           //数据来自发送区
            {
                strSend = this.rtxt_send.Text;
                if (chb_toHexSend.Checked == true)    //如果发送区显示的数据时十六进制，转换为正常编码
                {
                    strSend = Algorithm._16ToString(strSend);
                }
            }

            byte[] data = Algorithm.StringToBtyes(strSend);
            sp.Write(data, 0, data.Length);
            nSend_count += data.Length;
            this.lab_sendCount.Text = "发送:" + nSend_count.ToString();
        }
        private void chb_toHexSend_Click(object sender, EventArgs e)
        {
            if (chb_sendFile.Checked == false)     //如果发送的数据来自文件，发送区显示的是文件路径，无需转换
            {
                if (chb_toHexSend.Checked)      //如果是十六进制发送,发送区的内容显示为16进制，但是发送时还是正常转换为byte
                {
                    string str = this.rtxt_send.Text;
                    this.rtxt_send.Text = Algorithm.StringTo16(str, Enum16进制隔离符.空格);
                }
                else
                {
                    string str = this.rtxt_send.Text;
                    this.rtxt_send.Text = Algorithm._16ToString(str);
                }
            }
        }

        //数据循环发送
        private void chb_loopSend_Click(object sender, EventArgs e)
        {
            if(chb_loopSend.Checked==true)
            {
                timerLoop.Interval = Convert.ToInt32(this.txt_period.Text);
                //timerLoop.Start();
            }
            else
            {
                if (btn_send.Text == "停止发送")
                {
                    btn_send.Text = "发送";
                    timerLoop.Stop();
                }            
            }
        }

        private void LoopSend(object sender, EventArgs e)
        {
            Send();
        }

        private void btn_help_Click(object sender, EventArgs e)
        {
            MessageBox.Show("f","串口调试助手帮助文档");
        }
    }
}
