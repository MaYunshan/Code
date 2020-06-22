using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 泛型委托
{
    public delegate int DelCompare<T>(T t1,T t2);
    public delegate int Compare(object o1,object o2);
    class Program
    {
        static void Main(string[] args)
        {
            //Compare del = IntCompare;
            //object[] arr = { 34, 56, 3, 89, 75 };
            //object max = GetMax(arr, del);
            //Console.WriteLine(max);


            int[] arr = { 34, 2, 67, 98, 21 };
            DelCompare<int> del=intComp;
            int n = GetMax<int>(arr, intComp);
            Console.WriteLine(n);
        }
            
        public static T GetMax<T>(T[] arr,DelCompare<T> del)
        {
            T max = arr[0];
            for (int i = 1; i < arr.Length; i++)
            {
                if (del(max, arr[i]) < 0)
                {
                    max = arr[i];
                }
            }
            return max;
        }

        public static int intComp(int n1,int n2)
        {
            return n1 - n2;
        }

        public static int stringComp(string s1,string s2)
        {
            return s1.Length - s2.Length;
        }


        public static object GetMax(object[] os,Compare comp)
        {
            object max = os[0];
            for (int i = 1; i < os.Length;i++ )
            {
                if (comp(max, os[i]) < 0)
                {
                    max = os[i];
                }
            }
            return max;
        }

        public static int IntCompare(object o1,object o2)
        {
            int n1 = (int)o1;
            int n2 = (int)o2;
            return n1 - n2;
        }

        public static int StringCompare(object o1, object o2)
        {
            string s1 = (string)o1;
            string s2 = (string)o2;
            return s1.Length - s2.Length;
        }
    }
}
