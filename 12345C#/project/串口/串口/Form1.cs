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

namespace 串口
{
    public partial class Form1 : Form
    {

        SerialPort sp = new SerialPort();
        private StringBuilder builder = new StringBuilder();
        private long received_count = 0;                         //接收计数；
        public delegate void RecvDisplayHandler(byte[] buf);

        RecvDisplayHandler RecvCallBack;

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            string[] ports = SerialPort.GetPortNames();                  //获取电脑上所有串口
            Array.Sort(ports);
            cmb_port.Items.AddRange(ports);                             //将串口全部添加到下拉框中
            cmb_port.SelectedIndex = cmb_port.Items.Count > 0 ? 0 : -1;   //默认选项

            //sp.PortName = cmb_port.Text;
            

            sp.DataReceived += new SerialDataReceivedEventHandler(RecvData);   //注册事件，当串口接收到数据时触发

            RecvCallBack = new RecvDisplayHandler(RecvDisplay);

        }

        private void RecvData(object sender, SerialDataReceivedEventArgs e)
        {
            
            int nRead = sp.BytesToRead;
            byte[] recv = new byte[nRead];
            received_count += nRead;
            sp.Read(recv, 0, nRead);
            builder.Clear();

            this.rtxt_recv.Invoke(RecvCallBack, recv);
        }

        private void RecvDisplay(byte[] buf)
        {
            builder.Append(Encoding.Default.GetString(buf));
            this.rtxt_recv.AppendText(builder.ToString() + "\r\n");
        }

        private void btn_open_Click(object sender, EventArgs e)
        {
            
            if(sp.IsOpen)
            {
                sp.Close();
            }
            try
            {
                sp.PortName = cmb_port.Text;
                sp.BaudRate = 9600;
                sp.StopBits = StopBits.One;
                sp.DataBits = 8;
                sp.Parity = Parity.None;            //设置串口属性
                sp.ReceivedBytesThreshold = 1;       //设置 DataReceived 事件发生前内部输入缓冲区中的字节数
               
                sp.Open();
            }
            catch(Exception ex)
            {
                sp = new SerialPort();
                MessageBox.Show(ex.Message);
            }
            
        }

        private void btn_send_Click(object sender, EventArgs e)
        {
            if(sp.IsOpen)
            {
                string str = this.rtxt_send.Text;
                sp.Write(str);
            }
        }

        private void btn_close_Click(object sender, EventArgs e)
        {
            if(sp.IsOpen)
            {
                Application.DoEvents();
                sp.Close();              
                received_count = 0; 
            }
        }

        private void btn_quit_Click(object sender, EventArgs e)
        {
            if (sp.IsOpen)
            {
                Application.DoEvents();
                sp.Close();
                received_count = 0;
            }
            this.Close();
        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            if (sp.IsOpen)
            {
                Application.DoEvents();
                sp.Close();
                received_count = 0;
            }
        }
    }
}
