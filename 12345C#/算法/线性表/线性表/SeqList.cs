using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace 线性表
{
    /// <summary>
    /// 线性表的实现
    /// </summary>
    /// <typeparam name="T"></typeparam>
    class SeqList<T>:IListDS<T>
    {

        private T[] data;    //用来存储数据
        private int count=0;   //表示当前存储数据的大小

        public SeqList(int size)
        {
            data = new T[size];
            count = 0;
        }
        public SeqList()
        {
            data = new T[10];
            count = 0;  
        }
        public int GetLength()
        {
            return count;
        }

        public void Clear()
        {
            count = 0;
        }

        public bool IsEmpty()
        {
            return count == 0;
        }

        public void Add(T item)
        {
            //System.Diagnostics.Trace.Assert(count <= data.Length, "当前数组已满，不允许输入");
            //data[count] = item;
            //count++;
            if (count == data.Length) //当前数组已经存满
            {
                Console.WriteLine("当前顺序表已经存满，不允许再存入");
            }
            else
            {
                data[count] = item;
                count++;
            }
        }

        public void Insert(T item, int index)
        {
            if (count == data.Length) //当前数组已经存满
            {
                Console.WriteLine("当前顺序表已经存满，不允许再存入");
            }
            else
            {
                for (int i = count - 1; i>=index;i--)
                {
                    data[i + 1] = data[i];
                }
                data[index] = item;
                count++;
            }
        }

        public T Delete(int index)
        {
            T temp = data[index];
            for(int i=index;i<data.Length-1;i++)
            {
                data[i] = data[i + 1];
            }
            count--;
            return temp;
        }

        public T GetEle(int index)
        {
            if (index >= 0 && index <= count - 1) //索引存在
            {
                return data[index];
            }
            else
            {
                Console.WriteLine("索引不存在");
                return default(T);
            }
        }

        public T this[int index]
        {
            get { return GetEle(index); }
        }

        public int Locate(T item)
        {
            for (int i = 0; i < count; i++)
            {
                if (data[i].Equals(item))
                {
                    return i;
                }
            }
            return -1;
        }
    }
}
