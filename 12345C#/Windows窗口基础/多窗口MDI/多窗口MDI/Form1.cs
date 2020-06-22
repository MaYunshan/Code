using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 多窗口MDI
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            //Form2 f2 = new Form2();
            //f2.MdiParent = this;
            //f2.Show();

            //Form3 f3 = new Form3();
            //f3.MdiParent = this;
            //f3.Show();

            //Form4 f4 = new Form4();
            //f4.MdiParent = this;
            //f4.Show();

            //Form5 f5 = new Form5();
            //f5.MdiParent = this;
            //f5.Show();
        }

        private void 加载子窗口ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form2 f2 = new Form2();
            f2.MdiParent = this;
            f2.Show();

            Form3 f3 = new Form3();
            f3.MdiParent = this;
            f3.Show();

            Form4 f4 = new Form4();
            f4.MdiParent = this;
            f4.Show();

            Form5 f5 = new Form5();
            f5.MdiParent = this;
            f5.Show();
        }

        private void 水平平铺ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            LayoutMdi(MdiLayout.TileHorizontal);
        }

        private void 垂直平铺ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            LayoutMdi(MdiLayout.TileVertical);
        }

        private void 层叠排列ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            LayoutMdi(MdiLayout.Cascade);
        }

     
        
    }
}
