using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 登陆状态
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnSure_Click(object sender, EventArgs e)
        {
            try
            {
                if (txtName.Text == "")
                {
                    MessageBox.Show("用户姓名不能为空", "提示");
                    return;
                }
                if (txtPass.Text == "")
                {
                    MessageBox.Show("用户密码", "提示");
                    return;
                }
                if (radMan.Checked == false && radWoman.Checked == false)
                {
                    MessageBox.Show("请选择用户性别", "提示");
                    return;
                }
                if (ckInfo.Checked == false && ckMange.Checked == false && ckSell.Checked == false && ckShop.Checked == false)
                {
                    MessageBox.Show("请任选一项用户权限", "提示");
                    return;
                }// end 
                string strName = this.txtName.Text.ToString();
                string strPassword = this.txtPass.Text;
                string strPhon = this.txtPhone.Text;
                string srtEmail = this.txtMail.Text;
                string strAdress = this.txtAddress.Text;
                string strSex;
                if (radWoman.Checked == true)
                {
                    strSex = "女";
                }
                else
                {
                    strSex = "男";
                }
                string strCkNabge = "库存管理：" + "\n";
                string strCklsell = "销售管理：" + "\n";
                string strCklShop = "进货管理:" + "\n";
                string strCkl = "基本档案:" + "\n";

                if(ckLInfo.Visible==true)
                {
                    for(int i=0;i<ckLInfo.CheckedItems.Count;i++)
                    {
                        strCkl += ckLInfo.Items[i].ToString() + "\n";
                    }
                }

                if (this.ckLSell.Visible == true)
                {
                    for (int i = 0; i < ckLSell.CheckedItems.Count; i++)
                    {
                        strCkl += ckLSell.Items[i].ToString() + "\n";
                    }
                }

                if (this.ckLShop.Visible == true)
                {
                    for (int i = 0; i < ckLShop.CheckedItems.Count; i++)
                    {
                        strCkl += ckLShop.Items[i].ToString() + "\n";
                    }
                }

                if (this.ckLMange.Visible == true)
                {
                    for (int i = 0; i < ckLMange.CheckedItems.Count; i++)
                    {
                        strCkl += ckLMange.Items[i].ToString() + "\n";
                    }
                }

                MessageBox.Show("注册信息如下：" + "\n" + "姓名:" + strName + "\n" + "密码：" + strPassword + "\n" + "电话:"
                    + strPhon + "\n" + "邮箱:" + srtEmail + "\n" + "地址:" + strAdress + "\n" + "性别：" + strSex + "\n"
                    +  "用户权限如下：" + "\n" + strCkl + strCkNabge + strCklsell + strCklShop, "信息确认");
            }
            catch (Exception ee)
            {
                MessageBox.Show(ee.Message);
            }
        }

        private void btnQuit_Click(object sender, EventArgs e)
        {
           
        }


        private void ckInfo_CheckedChanged(object sender, EventArgs e)
        {
            if (ckInfo.Checked == true)
            {
                ckLInfo.Visible = true;
                CheckAll(ckLInfo);
            }
            else 
            {
                ckLInfo.Visible = false;
                CheckAllEsce(ckLInfo);
            }
        }

        //全部选中方法，参数传控件名称name 属性值 
        public void CheckAll(object chckList)
        {
            if (chckList.GetType().ToString() == "System.Windows.Forms.CheckedListBox")
            {
                CheckedListBox ckl = (CheckedListBox)chckList;
                for (int i = 0; i < ckl.Items.Count; i++)
                { ckl.SetItemCheckState(i, CheckState.Checked); }
            }// end block if 
        }//end mehtod block 
        //全部取选中方法，参数传控件名称name 属性值 
        public void CheckAllEsce(object chckList)
        {
            if (chckList.GetType().ToString() == "System.Windows.Forms.CheckedListBox")
            {
                CheckedListBox ckl = (CheckedListBox)chckList;
                for (int i = 0; i < ckl.Items.Count; i++)
                { ckl.SetItemCheckState(i, CheckState.Unchecked); }
            }// end block if 
        }

        private void ckShop_CheckedChanged(object sender, EventArgs e)
        {
            if (ckShop.Checked == true)
            {
                ckLShop.Visible = true;
                CheckAll(ckLShop);
            }
            else
            {
                ckLShop.Visible = false;
                CheckAllEsce(ckLShop);
            }
        }

        private void ckSell_CheckedChanged(object sender, EventArgs e)
        {
            if (ckSell.Checked == true)
            {
                ckLSell.Visible = true;
                CheckAll(ckLSell);
            }
            else
            {
                ckLSell.Visible = false;
                CheckAllEsce(ckLSell);
            }
        }

        private void ckMange_CheckedChanged(object sender, EventArgs e)
        {
            if (ckMange.Checked == true)
            {
                ckLMange.Visible = true;
                CheckAll(ckLMange);
            }
            else
            {
                ckLMange.Visible = false;
                CheckAllEsce(ckLMange);
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            radWoman.Checked = false;
            radMan.Checked = false;
        }

    }
}
