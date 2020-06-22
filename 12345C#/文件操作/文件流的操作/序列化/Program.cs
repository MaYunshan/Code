using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using System.Runtime.Serialization.Formatters.Binary;

namespace 序列化
{
    class Program
    {
        static void Main(string[] args)
        {
            string path=@"D:\12345C#\文件操作\文件流的操作\2.txt";
            Person p = new Person();
            p.Name = "张三";
            p.Age = 14;
            p.Sex = '男';

            //序列化
            //using (FileStream fWriter = new FileStream(path, FileMode.OpenOrCreate, FileAccess.Write))
            //{
            //    BinaryFormatter bf = new BinaryFormatter();
            //    bf.Serialize(fWriter, p);
            //}

            //反序列化
            Person p1;
            using (FileStream fReader = new FileStream(path, FileMode.OpenOrCreate, FileAccess.Read))
            {
                BinaryFormatter bf = new BinaryFormatter();
                p1 = (Person)bf.Deserialize(fReader);
            }
            Console.WriteLine(p1.Name);
            Console.WriteLine(p1.Age);
            Console.WriteLine(p1.Sex);

            Console.ReadKey();
        }
    }

    //要将序列化对象的类标记为可序列化的
    [Serializable]
    class Person
    {
        public string Name
        {
            set;
            get;
        }

        public int Age
        {
            set;
            get;
        }

        public char Sex
        {
            set;
            get;
        }
    }
}
