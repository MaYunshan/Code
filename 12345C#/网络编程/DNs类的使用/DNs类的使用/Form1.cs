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
using System.Net.Mail;

namespace DNs类的使用
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if(txtAddress.Text==string.Empty)
            {
                MessageBox.Show("请输入主机地址！");
            }
            else
            {
                txtHostAddress.Text = string.Empty;
                //根据dns域名获得ip地址，如果输入是ip地址，则返回值也是ip地址
                IPAddress[] ips = Dns.GetHostAddresses(txtAddress.Text);   
                foreach(IPAddress ip in ips)
                {
                    txtHostIP.Text = ip.ToString();
                    Console.WriteLine(ip.ToString());
                }
                //获得本地主机名
                txtHostAddress.Text = Dns.GetHostName();
                //txtDnsName.Text = Dns.GetHostByName(Dns.GetHostName()).HostName;
                txtDnsName.Text = Dns.GetHostEntry(Dns.GetHostName()).HostName;
            }
        }
    }
}
