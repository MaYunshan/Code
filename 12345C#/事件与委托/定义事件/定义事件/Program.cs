using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
namespace 定义事件
{
    class Program
    {
        static void Main(string[] args)
        {
            
            Employee ep = new Employee("mus",3333);    //事件来源的对象
            Reporter rp = new Reporter();             //事件处理的对象
            Finaical fp = new Finaical();               //事件处理的另外一个对象

            //指明玩游戏这个事件触发后，由谁来处理
            //一个事件触发两个处理
            ep.PlayGame += new DelegateClassHandle(rp.Notify);      //建立起一条委托。将事件来源和事件处理绑定
            ep.PlayGame += new DelegateClassHandle(fp.Penalty);     //建立另外一条委托，

            ep.Game();

            Console.ReadKey();
        }
    }

    /// <summary>
    /// 定义一个委托，，，，定义了一个标签，代表事件的格式
    /// 定义事件时，发生者首先要定义委托，然后根据委托定义事件。
          /// 委托相当于函数指针，它将事件响应函数的函数指针与类的事件字段绑定一起，
          /// 用来告诉事件发出者事件发出后事件的响应函数的起始位置。
          /// 事件的发出者就找到了响应函数的起始位置就可以完成事件的响应了。
    /// </summary>
    /// <param name="sender">触发事件的源头</param>
    /// <param name="e">同时携带的信息</param>
    public delegate void DelegateClassHandle(object sender,CustomEventArgs e);
    public class Employee
    {

        /// <summary>
        /// 定于一个DelegateClassHandle类型的事件
        /// </summary>
        public event DelegateClassHandle PlayGame;

        string m_name;    //员工姓名
        int m_id;      //员工编号


        public string Name
        {
            get { return m_name; }
            set { m_name = value; }
        }

        public int Id
        {
            get { return m_id; }
            set { m_id = value; }
        }

        public Employee(string str,int id)
        {
            this.m_name = str;
            this.m_id = id;
        }
        public void Game()
        {
            if (PlayGame != null)   //如果事件被定义了
            {
                Console.WriteLine("我要玩游戏了！");
                
                //实例化一个参数类
                CustomEventArgs e = new CustomEventArgs();
                e.SName = Name;
                e.NId = Id;
                PlayGame(this,e);
            }
        }     
    }
    /// <summary>
    /// 具体报告的类
    /// </summary>
    public class Reporter
    {
        public void Notify(object sender,CustomEventArgs e)
        {
            Console.WriteLine("{0}在{1}玩游戏了",e.SName,((Employee)sender).Id);
        }
    }

    /// <summary>
    /// 另外一个处理事件的类
    /// </summary>
    public class Finaical
    {
        public void Penalty(object sender,CustomEventArgs e)
        {
            Console.WriteLine("被罚款人:" + e.SName + "因上班玩游戏。被扣一个月工资");
        }
    }

    //定义一个事件类，用来传输事件信息
    public class CustomEventArgs:EventArgs
   {
        string sName = "";      //员工姓名
        int nId = 0;           //员工Id号

        public CustomEventArgs()
        {
        }
        public string SName
        {
            get
            {
                return this.sName;
            }
            set
            {
                this.sName = value;
            }
        }
        public int  NId
        {
            get
            {
                return this.nId;
            }
            set
            {
                this.nId = value;
            }
        }
   }
}
