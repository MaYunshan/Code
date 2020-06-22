using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 线性表
{
    interface IListDS<T>
    {
        int GetLength();
        void Clear();
        bool IsEmpty();
        void Add(T item);
        void Insert(T item, int index);
        T Delete(int index);
        T GetEle(int index);
        T this[int index] { get; }
        int Locate(T item);
    }
}
