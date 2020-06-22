using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 树控件
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            TreeNode tn1 = treeView1.Nodes.Add("名称");
        
            TreeNode tn2 = new TreeNode("温故知新");
            TreeNode tn3 = new TreeNode("学海无涯");
            TreeNode tn4 = new TreeNode("滴水穿石");

            tn1.Nodes.Add(tn2);
            tn1.Nodes.Add(tn3);
            tn1.Nodes.Add(tn4);
        }

        private void treeView1_AfterSelect(object sender, TreeViewEventArgs e)
        {
            label1.Text = "当前选中节点为：" + e.Node.Text;
        }
    }
}
