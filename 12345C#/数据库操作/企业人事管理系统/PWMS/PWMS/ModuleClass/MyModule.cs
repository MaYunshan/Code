using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;
using System.Data;
using System.Data.SqlClient;

namespace PWMS.ModuleClass
{
    class MyModule
    {
        #region  公共变量
        DataClass.MyMeans MyDataClass = new PWMS.DataClass.MyMeans();   //声明MyMeans类的一个对象，以调用其方法
        public static string ADDs = "";  //用来存储添加或修改的SQL语句
        public static string FindValue = "";  //存储查询条件
        public static string Address_ID = "";  //存储通讯录添加修改时的ID编号
        public static string User_ID = "";  //存储用户的ID编号
        public static string User_Name = "";    //存储用户名
        #endregion

        #region  将menuStrip控件中的信息添加到treeView控件中
        /// <summary>
        /// 读取菜单中的信息.
        /// </summary>
        /// <param name="treeV">TreeView控件</param>
        /// <param name="MenuS">MenuStrip控件</param>
        public void GetMenu(TreeView treeV, MenuStrip MenuS)
        {
            for (int i = 0; i < MenuS.Items.Count; i++)   //遍历MenuStrip组件中的一级菜单项
            {
                //将一级菜单项的名称添加到TreeView组件的根节点中，并设置当前节点的子节点newNode1
                TreeNode newNode1 = treeV.Nodes.Add(MenuS.Items[i].Text);
                //将当前菜单项的所有相关信息存入到ToolStripDropDownItem对象中
                ToolStripDropDownItem newmenu = (ToolStripDropDownItem)MenuS.Items[i];
                //判断当前菜单项中是否有二级菜单项
                if (newmenu.HasDropDownItems && newmenu.DropDownItems.Count > 0)
                    for (int j = 0; j < newmenu.DropDownItems.Count; j++)    //遍历二级菜单项
                    {
                        //将二级菜单名称添加到TreeView组件的子节点newNode1中，并设置当前节点的子节点newNode2
                        TreeNode newNode2 = newNode1.Nodes.Add(newmenu.DropDownItems[j].Text);
                        //将当前菜单项的所有相关信息存入到ToolStripDropDownItem对象中
                        ToolStripDropDownItem newmenu2 = (ToolStripDropDownItem)newmenu.DropDownItems[j];
                        //判断二级菜单项中是否有三级菜单项
                        if (newmenu2.HasDropDownItems && newmenu2.DropDownItems.Count > 0)
                            for (int p = 0; p < newmenu2.DropDownItems.Count; p++)    //遍历三级菜单项
                                //将三级菜单名称添加到TreeView组件的子节点newNode2中
                                newNode2.Nodes.Add(newmenu2.DropDownItems[p].Text);
                    }
            }
        }
        #endregion

        #region 禁用菜单栏
        public void MainMenuF(MenuStrip MenuS)
        {
            string Men = "";
            //从第一级子菜单开始，逐个遍历
            for (int i = 0; i < MenuS.Items.Count; i++)
            {   //获取第一级子菜单每一项的名字 ，如果此子菜单还有下一级菜单，那么Name里会有ToolStripMenuItem
                Men = ((ToolStripDropDownItem)MenuS.Items[i]).Name;
                if (Men.IndexOf("Menu") == -1)
                     //如果没有子菜单，那么Name里没有ToolStripMenuItem，那么就将它使能
                    ((ToolStripDropDownItem)MenuS.Items[i]).Enabled = false;
                ToolStripDropDownItem newmenu = (ToolStripDropDownItem)MenuS.Items[i];
                if (newmenu.HasDropDownItems && newmenu.DropDownItems.Count > 0)
                {
                    for (int j = 0; j < newmenu.DropDownItems.Count; j++)
                    {
                        Men = newmenu.DropDownItems[j].Name;
                        if (Men.IndexOf("Menu") == -1)
                            newmenu.DropDownItems[j].Enabled = false;
                        ToolStripDropDownItem newmenu2 = (ToolStripDropDownItem)newmenu.DropDownItems[j];
                        if (newmenu2.HasDropDownItems && newmenu2.DropDownItems.Count > 0)
                        {
                            for (int p = 0; p < newmenu2.DropDownItems.Count; p++)
                                newmenu2.DropDownItems[p].Enabled = false;
                        }                           
                    }
                }                    
            }
        }
        #endregion

        #region  根据用户权限设置主窗体菜单
        /// <summary>
        /// 根据用户权限设置菜单是否可用.
        /// </summary>
        /// <param name="MenuS">MenuStrip控件</param>
        /// <param name="UName">当前登录用户名</param>
        public void MainPope(MenuStrip MenuS, String UName)
        {
            string Str = "";
            string MenuName = "";
            DataSet DSet = MyDataClass.getDataSet("select ID from tb_Login where Name='" + UName + "'", "tb_Login");    //获取当前登录用户的信息
            string UID = Convert.ToString(DSet.Tables[0].Rows[0][0]);   //获取当前用户编号
            DSet = MyDataClass.getDataSet("select ID,PopeName,Pope from tb_UserPope where ID='" + UID + "'", "tb_UserPope");    //获取当前用户的权限信息
            bool bo = false;
            for (int k = 0; k < DSet.Tables[0].Rows.Count; k++) //遍历当前用户的权限名称
            {
                Str = Convert.ToString(DSet.Tables[0].Rows[k][1]);  //获取权限名称
                if (Convert.ToInt32(DSet.Tables[0].Rows[k][2]) == 1)    //判断权限是否可用
                    bo = true;
                else
                    bo = false;
                for (int i = 0; i < MenuS.Items.Count; i++) //遍历菜单栏中的一级菜单项
                {
                    ToolStripDropDownItem newmenu = (ToolStripDropDownItem)MenuS.Items[i];  //记录当前菜单项下的所有信息
                    if (newmenu.HasDropDownItems && newmenu.DropDownItems.Count > 0)    //如果当前菜单项有子级菜单项
                        for (int j = 0; j < newmenu.DropDownItems.Count; j++)    //遍历二级菜单项
                        {
                            MenuName = newmenu.DropDownItems[j].Name;   //获取当前菜单项的名称
                            if (MenuName.IndexOf(Str) > -1) //如果包含权限名称
                                newmenu.DropDownItems[j].Enabled = bo;  //根据权限设置可用状态
                            ToolStripDropDownItem newmenu2 = (ToolStripDropDownItem)newmenu.DropDownItems[j];   //记录当前菜单项的所有信息
                            if (newmenu2.HasDropDownItems && newmenu2.DropDownItems.Count > 0)  //如果当前菜单项有子级菜单项
                                for (int p = 0; p < newmenu2.DropDownItems.Count; p++)  //遍历三级菜单项
                                {
                                    MenuName = newmenu2.DropDownItems[p].Name;  //获取当前菜单项的名称
                                    if (MenuName.IndexOf(Str) > -1) //如果包含权限名称
                                        newmenu2.DropDownItems[p].Enabled = bo;  //根据权限设置可用状态
                                }
                        }
                }
            }
        }
        #endregion

        public void Show_Form(string FrmName, int n)
        {
            if (n == 1)
            {
                if (FrmName == "人事档案管理")  //判断当前要打开的窗体
                {
                    PerForm.F_ManFile FrmManFile = new PWMS.PerForm.F_ManFile();
                    FrmManFile.Text = "人事档案管理";   //设置窗体名称
                    FrmManFile.ShowDialog();    //显示窗体
                    FrmManFile.Dispose();
                }
                if (FrmName == "人事资料查询")
                {
                    PerForm.F_Find FrmFind = new PWMS.PerForm.F_Find();
                    FrmFind.Text = "人事资料查询";
                    FrmFind.ShowDialog();
                    FrmFind.Dispose();
                }
                if (FrmName == "人事资料统计")
                {
                    PerForm.F_Stat FrmStat = new PWMS.PerForm.F_Stat();
                    FrmStat.Text = "人事资料统计";
                    FrmStat.ShowDialog();
                    FrmStat.Dispose();
                }
                //if (FrmName == "员工生日提示")
                //{
                //    InfoAddForm.F_ClewSet FrmClewSet = new PWMS.InfoAddForm.F_ClewSet();
                //    FrmClewSet.Text = "员工生日提示";   //设置窗体名称
                //    FrmClewSet.Tag = 1; //设置窗体的Tag属性，用于在打开窗体时判断窗体的显示类形
                //    FrmClewSet.ShowDialog();    //显示窗体
                //    FrmClewSet.Dispose();
                //}
                //if (FrmName == "员工合同提示")
                //{
                //    InfoAddForm.F_ClewSet FrmClewSet = new PWMS.InfoAddForm.F_ClewSet();
                //    FrmClewSet.Text = "员工合同提示";
                //    FrmClewSet.Tag = 2;
                //    FrmClewSet.ShowDialog();
                //    FrmClewSet.Dispose();
                //}
                if (FrmName == "日常记事")
                {
                    PerForm.F_WordPad FrmWordPad = new PWMS.PerForm.F_WordPad();
                    FrmWordPad.Text = "日常记事";
                    FrmWordPad.ShowDialog();
                    FrmWordPad.Dispose();
                }
                if (FrmName == "通讯录")
                {
                    PerForm.F_AddressList FrmAddressList = new PWMS.PerForm.F_AddressList();
                    FrmAddressList.Text = "通讯录";
                    FrmAddressList.ShowDialog();
                    FrmAddressList.Dispose();
                }
                if (FrmName == "备份/还原数据库")
                {
                    PerForm.F_HaveBack FrmHaveBack = new PWMS.PerForm.F_HaveBack();
                    FrmHaveBack.Text = "备份/还原数据库";
                    FrmHaveBack.ShowDialog();
                    FrmHaveBack.Dispose();
                }
                if (FrmName == "清空数据库")
                {
                    PerForm.F_ClearData FrmClearData = new PWMS.PerForm.F_ClearData();
                    FrmClearData.Text = "清空数据库";
                    FrmClearData.ShowDialog();
                    FrmClearData.Dispose();
                }

                if (FrmName == "重新登录")
                {
                    F_Login FrmLogin = new F_Login();
                    FrmLogin.Tag = 2;
                    FrmLogin.ShowDialog();
                    FrmLogin.Dispose();
                }
                if (FrmName == "用户设置")
                {
                    PerForm.F_User FrmUser = new PWMS.PerForm.F_User();
                    FrmUser.Text = "用户设置";
                    FrmUser.ShowDialog();
                    FrmUser.Dispose();
                }
                if (FrmName == "计算器")
                {
                    System.Diagnostics.Process.Start("calc.exe");
                }
                if (FrmName == "记事本")
                {
                    System.Diagnostics.Process.Start("notepad.exe");
                }
                if (FrmName == "系统帮助")
                {
                    System.Diagnostics.Process.Start("readme.doc");
                }
            }

            if (n == 2)
            {
                String FrmStr = ""; //记录窗体名称
                if (FrmName == "民族类别设置")  //判断要打开的窗体
                {
                    DataClass.MyMeans.Mean_SQL = "select * from tb_Folk";   //SQL语句
                    DataClass.MyMeans.Mean_Table = "tb_Folk";   //表名
                    DataClass.MyMeans.Mean_Field = "FolkName";  //添加、修改数据的字段名
                    FrmStr = FrmName;
                }

                InfoAddForm.F_Basic FrmBasic = new PWMS.InfoAddForm.F_Basic();
                FrmBasic.Text = FrmStr; //设置窗体名称
                FrmBasic.ShowDialog();  //显示调用的窗体
                FrmBasic.Dispose();
            }
        }
    }
}
