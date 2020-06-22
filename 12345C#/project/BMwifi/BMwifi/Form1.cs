using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BMwifi
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        string account = string.Empty;
        string password = string.Empty;
        /// <summary>
        /// 点击开始按钮
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btn_start_Click(object sender, EventArgs e)
        {
            account = txt_account.Text.Trim();
            password = txt_password.Text.Trim();
            if (account == string.Empty)
            {
                MessageBox.Show("账号为空！","错误提示",MessageBoxButtons.OK,MessageBoxIcon.Error);
                return;
            }
            else if (password == string.Empty)
            {
                MessageBox.Show("密码为空！", "错误提示", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }

            //开启网卡的cmd命令netsh wlan set hostednetwork mode=allow ssid=qa key=11112222
            //拼接出执行命令
            string strcmd = string.Format("netsh wlan set hostednetwork mode=allow ssid={0} key={1}", account, password);

            string result = CmdHelper.ExecuteCom(strcmd);
            MessageBox.Show(result);
        }
    }
}
