using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 计算器
{
    public partial class frmMain : Form
    {
        private double dNumb1 = 0;      //第一操作数
        private double dNumb2;          //第二操作数
        private string sigh;            //符号
        private double dResult;         //结果
        private bool bCheck = true;           //检查是否为第一操作数
        private double dAns = 0;         //保存上一次的结果
        
        public frmMain()
        {
            InitializeComponent();
        }
        private void btn0_Click(object sender, EventArgs e)
        {
            if(this.tbResult.Text!="")
            {
                if (bCheck)
                {
                    Button btn = (Button)sender;
                    this.tbResult.Text += btn.Text;
                    dNumb1 = double.Parse(tbResult.Text);
                }
                else
                {
                    Button btn = (Button)sender;
                    this.tbResult.Text += btn.Text;
                    dNumb2 = double.Parse(tbResult.Text);
                }
            }
        }
        private void btn1_Click(object sender, EventArgs e)
        {
            if(bCheck)
            {
                Button btn = (Button)sender;
                this.tbResult.Text += btn.Text;
                dNumb1 = double.Parse(tbResult.Text);
            }
            else
            {
                Button btn = (Button)sender;
                this.tbResult.Text += btn.Text;
                dNumb2 = double.Parse(tbResult.Text);
            }
        }

        private void btn2_Click(object sender, EventArgs e)
        {
            if (bCheck)
            {
                Button btn = (Button)sender;
                this.tbResult.Text += btn.Text;
                dNumb1 = double.Parse(tbResult.Text);
            }
            else
            {
                Button btn = (Button)sender;
                this.tbResult.Text += btn.Text;
                dNumb2 = double.Parse(tbResult.Text);
            }
        }

        private void btn3_Click(object sender, EventArgs e)
        {
            if (bCheck)
            {
                Button btn = (Button)sender;
                this.tbResult.Text += btn.Text;
                dNumb1 = double.Parse(tbResult.Text);
            }
            else
            {
                Button btn = (Button)sender;
                this.tbResult.Text += btn.Text;
                dNumb2 = double.Parse(tbResult.Text);
            }
        }

        private void btn4_Click(object sender, EventArgs e)
        {
            if (bCheck)
            {
                Button btn = (Button)sender;
                this.tbResult.Text += btn.Text;
                dNumb1 = double.Parse(tbResult.Text);
            }
            else
            {
                Button btn = (Button)sender;
                this.tbResult.Text += btn.Text;
                dNumb2 = double.Parse(tbResult.Text);
            }
        }

        private void btn5_Click(object sender, EventArgs e)
        {
            if (bCheck)
            {
                Button btn = (Button)sender;
                this.tbResult.Text += btn.Text;
                dNumb1 = double.Parse(tbResult.Text);
            }
            else
            {
                Button btn = (Button)sender;
                this.tbResult.Text += btn.Text;
                dNumb2 = double.Parse(tbResult.Text);
            }
        }

        private void btn6_Click(object sender, EventArgs e)
        {
            if (bCheck)
            {
                Button btn = (Button)sender;
                this.tbResult.Text += btn.Text;
                dNumb1 = double.Parse(tbResult.Text);
            }
            else
            {
                Button btn = (Button)sender;
                this.tbResult.Text += btn.Text;
                dNumb2 = double.Parse(tbResult.Text);
            }
        }

        private void btn7_Click(object sender, EventArgs e)
        {
            if (bCheck)
            {
                Button btn = (Button)sender;
                this.tbResult.Text += btn.Text;
                dNumb1 = double.Parse(tbResult.Text);
            }
            else
            {
                Button btn = (Button)sender;
                this.tbResult.Text += btn.Text;
                dNumb2 = double.Parse(tbResult.Text);
            }
        }

        private void btn8_Click(object sender, EventArgs e)
        {
            if (bCheck)
            {
                Button btn = (Button)sender;
                this.tbResult.Text += btn.Text;
                dNumb1 = double.Parse(tbResult.Text);
            }
            else
            {
                Button btn = (Button)sender;
                this.tbResult.Text += btn.Text;
                dNumb2 = double.Parse(tbResult.Text);
            }
        }

        private void btn9_Click(object sender, EventArgs e)
        {
            if (bCheck)
            {
                Button btn = (Button)sender;
                this.tbResult.Text += btn.Text;
                dNumb1 = double.Parse(tbResult.Text);
            }
            else
            {
                Button btn = (Button)sender;
                this.tbResult.Text += btn.Text;
                dNumb2 = double.Parse(tbResult.Text);
            }
        }

        private void btnAdd_Click(object sender, EventArgs e)  //加法
        {
            sigh = "+";
            bCheck = false;
            tbResult.Clear();
        }

        private void btnSub_Click(object sender, EventArgs e) //减法
        {
            sigh = "-";
            bCheck = false;
            tbResult.Clear();
        }

        private void btnMultiply_Click(object sender, EventArgs e)//乘法
        {
            sigh = "*";
            bCheck = false;
            tbResult.Clear();
        }

        private void btnDivide_Click(object sender, EventArgs e)//除法
        {
            sigh = "/";
            bCheck = false;
            tbResult.Clear();
        }

        private void btnPersent_Click(object sender, EventArgs e)//取余
        {
            sigh = "%";
            bCheck = false;
            tbResult.Clear();
        }

        private void btnInverse_Click(object sender, EventArgs e)//取倒数
        {
            sigh = "Inverse";
            bCheck = false;
            tbResult.Clear();
        }

        private void btnSqrt_Click(object sender, EventArgs e) //开根号
        {
            sigh = "Sqrt";
            bCheck = false;
            tbResult.Clear();
        }

        private void btnClear_Click(object sender, EventArgs e) //清除当前text内容
        {
            this.tbResult.Clear();
        }

        private void btnReset_Click(object sender, EventArgs e) //计算器淸0
        {
            dNumb1 = 0;
            dNumb2 = 0;
            sigh = "";
            dResult = 0;
            bCheck = true;
            dAns = 0;    
        }

        private void btnAns_Click(object sender, EventArgs e)
        {

        }

        private void btnEqual_Click(object sender, EventArgs e)
        {
            bCheck = true;
            if(sigh!="")
            {
                Console.WriteLine(dNumb1);
                Console.WriteLine(dNumb2);
                switch(sigh)
                {
                    case"+":
                        dResult = dNumb1 + dNumb2;
                        break;
                    case "-":
                        dResult = dNumb1 - dNumb2;
                        break;
                    case "*":
                        dResult = dNumb1 * dNumb2;
                        break;
                    case "/":
                        dResult = dNumb1 / dNumb2;
                        break;
                    case "%":
                        dResult = dNumb1 % dNumb2;
                        break;
                    case "Inverse":
                        dResult = 1/dNumb1;
                        break;
                    case "Sqrt":
                        dResult = Math.Sqrt(dNumb1);
                        break;

                }
                dNumb1 = dResult;
                Console.WriteLine(dResult);
                dAns = dNumb1;
                this.tbResult.Text = dResult.ToString();
            }
        }

        
    }
}
