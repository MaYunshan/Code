using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace 资源管理器
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            TreeNode CountNode = new TreeNode("我的电脑");
            TreeViewFile.Nodes.Add(CountNode);
            listViewShow(CountNode);
        }

        //初始化ListView控件，把TrreView控件中的数据添加进来
        private void listViewShow(TreeNode NodeDir)
        {
            ListViewFile.Clear();
            try
            {
                if (NodeDir.Parent == null)// 如果当前TreeView的父结点为空，就把我的电脑下的分区名称添加进来
                {
                    foreach (string DrName in Directory.GetLogicalDrives())//获得硬盘分区名
                    {
                        ListViewItem ItemList = new ListViewItem(DrName);
                        ListViewFile.Items.Add(ItemList);
                    }
                }
                else//如果当前TreeView的父结点不为空，把点击的结点，做为一个目录文件的总结点
                {
                    foreach (string DirName in Directory.GetDirectories((string)NodeDir.Tag))//编历当前分区或文件夹所有目录
                    {
                        ListViewItem ItemList = new ListViewItem(DirName);
                        ListViewFile.Items.Add(ItemList);
                    }
                    foreach (string FileName in Directory.GetFiles((string)NodeDir.Tag))//编历当前分区或文件夹所有目录的文件
                    {
                        ListViewItem ItemList = new ListViewItem(FileName);
                        ListViewFile.Items.Add(ItemList);
                    }//
                }
            }
            catch
            {  }
        }

        private void ListViewShow(string DirName)
        {
            ListViewFile.Clear();
            try
            {
                foreach (string dirName in Directory.GetDirectories(DirName))  
                {
                    ListViewItem listItem = new ListViewItem(dirName);
                    ListViewFile.Items.Add(listItem);
                }
                foreach (string FileName in Directory.GetFiles(DirName))
                {
                    ListViewItem ItemList = new ListViewItem(FileName);
                    ListViewFile.Items.Add(ItemList);
                }
            }
            catch { }
        }
        private void TreeViewShow(TreeNode NodeDir)
        {
            try
            {
                if (NodeDir.Nodes.Count == 0)
                {
                    if (NodeDir.Parent == null)//如果结点为空显示硬盘分区
                    {
                        foreach (string DrvName in Directory.GetLogicalDrives())
                        {
                            TreeNode aNode = new TreeNode(DrvName);
                            aNode.Tag = DrvName;
                            NodeDir.Nodes.Add(aNode);
                        }
                    }// end 
                    else// 不为空，显示分区下文件夹
                    {
                        foreach (string DirName in Directory.GetDirectories((string)NodeDir.Tag))
                        {
                            TreeNode aNode = new TreeNode(DirName);
                            aNode.Tag = DirName;
                            NodeDir.Nodes.Add(aNode);
                        }
                    }
                }
            }
            catch { }
        }
        private void TreeViewFile_AfterSelect(object sender, TreeViewEventArgs e)
        {
            listViewShow(e.Node);
            TreeViewShow(e.Node);
        }

       

        private void ListViewFile_DoubleClick(object sender, EventArgs e)
        {
            foreach (int ListIndex in ListViewFile.SelectedIndices)
            {
                ListViewShow(ListViewFile.Items[ListIndex].Text);
            }
        }

      
    }
}
