using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Test01
{
    interface IPeople
    {
        /// <summary>
        /// 姓名
        /// </summary>
        string Name
        {
            get;
            set;
        }
        /// <summary>
        /// 性别
        /// </summary>
        string Sex
        {
            get;
            set;
        }
    }
    interface ITeacher : IPeople            //继承公共接口
    {
        /// <summary>
        /// 教学方法
        /// </summary>
        void teach();
    }
    interface IStudent : IPeople            //继承公共接口
    {
        /// <summary>
        /// 学习方法
        /// </summary>
        void study();
    }
    class Program : IPeople, ITeacher, IStudent//多接口继承
    {
        string name = "";
        string sex = "";
        /// <summary>
        /// 姓名
        /// </summary>
        public string Name
        {
            get
            {
                return name;
            }
            set
            {
                name = value;
            }
        }
        /// <summary>
        /// 性别
        /// </summary>
        public string Sex
        {
            get
            {
                return sex;
            }
            set
            {
                sex = value;
            }
        }
        /// <summary>
        /// 教学方法
        /// </summary>
        public void teach()
        {
            Console.WriteLine(Name + " " + Sex + " 教师");
        }
        /// <summary>
        /// 学习方法
        /// </summary>
        public void study()
        {
            Console.WriteLine(Name + " " + Sex + " 学生");       
        }
        static void Main(string[] args)
        {
            Program program = new Program();   //实例化类对象
            program.Name = "TM";
            program.Sex = "男";
            program.study();
            program.teach();

            Console.ReadLine();

            //ITeacher iteacher = program;       //使用派生类对象实例化接口ITeacher
            //iteacher.Name = "TM";
            //iteacher.Sex = "男";
            //iteacher.teach();
            //IStudent istudent = program;       //使用派生类对象实例化接口IStudent
            //istudent.Name = "C#";
            //istudent.Sex = "男";
            //istudent.study();
        }
    }
}
