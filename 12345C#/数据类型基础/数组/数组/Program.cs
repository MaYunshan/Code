
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 数组
{
    class Program
    {
        static void Main(string[] args)
        {
            //一维数组
            int[] arr;
            arr = new int[3]{3,4,5};
            foreach (int x in arr)
                Console.WriteLine("元素分别是{0}:",x);

            //不规则二维数组
            int[][] arr1=new int[2][];
            arr1[0] = new int[2];
            arr1[1] = new int[3];
            Console.WriteLine(arr1.GetLength(0));
            Console.WriteLine(arr1[0].GetLength(0));
            Console.WriteLine(arr1[1].GetLength(0));

            //规则二维数组
            int[,] arr2=new int[3,4]{{4,3,7,6},{7,8,1,9},{5,7,1,0}};
            //Array.Sort(arr2);



            Console.ReadLine();

        }
    }
}
