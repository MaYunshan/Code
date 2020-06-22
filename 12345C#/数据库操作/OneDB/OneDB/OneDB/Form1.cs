using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;

namespace OneDB
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            //数据库连接时的格式化字符串
            string strConn = "server=DESKTOP-RUSEPIQ;database=OneDB;uid=sa;pwd=123";
            //实例化数据库连接对象  ，抽水管
            SqlConnection conn = new SqlConnection(strConn);
            //打开数据库
            conn.Open();

            //用来执行SQL语句的对象
            SqlCommand cmd = new SqlCommand();

            
            cmd.CommandText = "select id,name from classify";
            //指定上面命令的类型是SQL语句还是存储过程
            cmd.CommandType = CommandType.Text;

            //抽水机跟那条抽水管连接
            cmd.Connection = conn;

            //数据流对象，类似于抽水管，保存cmd的查询结果
            SqlDataReader sdr = cmd.ExecuteReader();
            //sdr.read的作用是前进到下一条指令
            while(sdr.Read())
            {
                comboBox1.Items.Add(sdr[0] + "--" + sdr["name"]);
            }

            //关闭数据流对象，断开输水管
            sdr.Close();
            //关闭数据库连接对象，断开抽水管
            conn.Close();
        }

        private void button1_Click(object sender, EventArgs e)
        {

            //数据库连接时的格式化字符串
            string strConn = "server=DESKTOP-RUSEPIQ;database=OneDB;uid=sa;pwd=123";
            //实例化数据库连接对象  ，抽水管
            SqlConnection conn = new SqlConnection(strConn);
            //打开数据库
            conn.Open();

            //获取分类的id
            int i = comboBox1.Text.IndexOf("--");            //获取“--”匹配的第一个索引
            string id = comboBox1.Text.Substring(0, i);

            //用来执行SQL语句的对象
            SqlCommand cmd = new SqlCommand();
            cmd.CommandText = "select * from product where c_id=" + id;
            cmd.CommandType = CommandType.Text;
            cmd.Connection = conn;

            listBox1.Items.Clear();

            SqlDataReader sdr = sdr = cmd.ExecuteReader();
            while(sdr.Read())
            {
                listBox1.Items.Add(sdr["name"]);
            }

           
            //关闭数据流对象，断开输水管
            sdr.Close();
            //关闭数据库连接对象，断开抽水管
            conn.Close();
        }

         
        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
             //数据库连接时的格式化字符串
            string strConn = "server=DESKTOP-RUSEPIQ;database=OneDB;uid=sa;pwd=123";
            //实例化数据库连接对象  ，抽水管
            SqlConnection conn = new SqlConnection(strConn);
            //打开数据库
            conn.Open();

            string strName = listBox1.SelectedItem.ToString();
            //MessageBox.Show(strName);

            //用来执行SQL语句的对象
            SqlCommand cmd = new SqlCommand();
            cmd.CommandText = string.Format("select * from product where name='{0}'",strName);
            cmd.CommandType = CommandType.Text;
            cmd.Connection = conn;

            SqlDataReader sdr=cmd.ExecuteReader();

            sdr.Read();

            string str = string.Format("{0} {1} {2} {3} {4}",
                           sdr[0].ToString(),sdr[1].ToString() , sdr[2].ToString() , sdr[3].ToString(),sdr[4].ToString());
            label2.Text = str;


            //关闭数据流对象，断开输水管
            sdr.Close();
            //关闭数据库连接对象，断开抽水管
            conn.Close();
        }
    }
}
