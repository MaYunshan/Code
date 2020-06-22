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

namespace 线程画多边形
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void DrawGraph()
        {
            int loop = 0;
            int sect = 0;
            float[] x = new float[31];
            float[] y = new float[31];
            while(loop<10000)
            {
                sect = (sect + 1) % 25 + 1;
                Graphics ghs = this.CreateGraphics();
                for(int i=0;i<sect;i++)
                {
                    x[i] = (float)(150 * Math.Cos(i * 2 * Math.PI / sect) + 150);
                    y[i] = (float)(150 * Math.Sin(i * 2 * Math.PI / sect) + 150);
                }

                for(int m=0;m<sect-1;m++)
                {
                    for(int n=0;n<sect;n++)
                    {
                        ghs.DrawLine(Pens.Blue, x[m], y[m], x[n], y[n]);
                    }
                }
                Thread.Sleep(500);
                ghs.Clear(BackColor);
                loop++;
            }
        }

        Thread DrawGraphThead;
        private void btn_start_Click(object sender, EventArgs e)
        {
            //把画图函数交给新定义的委托
            ThreadStart entryPoint = new ThreadStart(DrawGraph);
            //ThreadStart entryPoing = DrawGraph;
            
            //把委托放入新线程中
            DrawGraphThead = new Thread(entryPoint);

            DrawGraphThead.Start();
            btn_start.Enabled = false;
            btn_pause.Enabled = true;
            btn_restart.Enabled = false;
            btn_stop.Enabled = true;
            this.label1.Text = DrawGraphThead.ThreadState.ToString();
        }

        private void btn_pause_Click(object sender, EventArgs e)
        {
            DrawGraphThead.Suspend();
            btn_start.Enabled = false;
            btn_pause.Enabled = false;
            btn_restart.Enabled = true;
            btn_stop.Enabled = false;
            this.label1.Text = DrawGraphThead.ThreadState.ToString();

        }

        private void btn_restart_Click(object sender, EventArgs e)
        {
            DrawGraphThead.Resume();
            btn_start.Enabled = false;
            btn_pause.Enabled = true;
            btn_restart.Enabled = false;
            btn_stop.Enabled = true;
            this.label1.Text = DrawGraphThead.ThreadState.ToString();
        }

        private void btn_stop_Click(object sender, EventArgs e)
        {
            DrawGraphThead.Abort();
            btn_start.Enabled = true;
            btn_pause.Enabled = false;
            btn_restart.Enabled = false;
            btn_stop.Enabled = false;
            this.label1.Text = DrawGraphThead.ThreadState.ToString();
        }

        private void btn_status_Click(object sender, EventArgs e)
        {
            this.label1.Text = DrawGraphThead.ThreadState.ToString();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            //后台的程序不妨碍程序的中止
            DrawGraphThead.IsBackground = true;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.label2.Text = DrawGraphThead.IsAlive.ToString();
        }
    }
}
