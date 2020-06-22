using System;
using System.Collections.Generic;
using System.Text;
using System.Data;
using System.Data.SqlClient;
using System.Windows.Forms;

namespace PWMS.DataClass
{
    class MyMeans
    {
        #region  全局变量
        public static string Login_ID = "";        //定义全局变量，记录当前登录的用户编号
        public static string Login_Name = "";      //定义全局变量，记录当前登录的用户名
        public static string Mean_SQL = "";
        public static string Mean_Table = "";
        public static string Mean_Field = "";     //定义全局变量，记录“基础信息”各窗体中的表名及SQL语句
        public static SqlConnection My_con;       //定义一个SqlConnection类型的公共变量My_con，用于判断数据库是否连接成功
        public static string M_str_sqlcon = "server=DESKTOP-RUSEPIQ;database=db_PWMS;uid=sa;pwd=123";

        public static int Login_n = 0;                                //用户登录与重新登录的标识
        public static string AllSql = "Select * from tb_Stuffbasic";    //存储职工基本信息表中的SQL语句
        #endregion

        #region 建立数据库
        public static SqlConnection getcon()
        {
            My_con = new SqlConnection(M_str_sqlcon);
            My_con.Open();
            return My_con;
        }
        #endregion

        #region 测试数据库是否加载正常
        public void con_open()
        {
            getcon();
            //con_close();
        }
        #endregion

        #region 关闭数据库
        public void con_close()
        {
            if(My_con.State==ConnectionState.Open)
            {
                My_con.Close();   //关闭数据库的连接
                My_con.Dispose();   //释放My_con变量的所有空间
            }
        }
        #endregion

        #region  读取指定表中的信息
        /// <summary>
        /// 读取指定表中的信息.
        /// </summary>
        /// <param name="SQLstr">SQL语句</param>
        /// <returns>返回bool型</returns>
        public SqlDataReader getcom(string SQLstr)
        {
            getcon();   //打开与数据库的连接
            SqlCommand My_com = My_con.CreateCommand(); //创建一个SqlCommand对象，用于执行SQL语句
            My_com.CommandText = SQLstr;    //获取指定的SQL语句
            SqlDataReader My_read = My_com.ExecuteReader(); //执行SQL语名句，生成一个SqlDataReader对象
            return My_read;
        }
        #endregion

        #region 创建dataset对象
        public DataSet getDataSet(string SQLstr,string tableName)
        {
            getcon();
            SqlDataAdapter SQLda = new SqlDataAdapter(SQLstr, My_con);
            DataSet My_DataSet = new DataSet();
            SQLda.Fill(My_DataSet, tableName);
            con_close();
            return My_DataSet;
        }
        #endregion
    }
}
