using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Diagnostics;

//在调试模式下运行程序时，并不仅仅是运行编写好的代码。调试
//程序包含了应用程序的符号信息，所以IDE 知道执行每行代码时发生了什么。符号信息意味着跟踪
//(例如)未编译代码中使用的变量名

namespace 调试
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] testArray = { 4, 7, 4, 2, 7, 3, 7, 8, 3, 9, 1, 9 };
            int[] maxValIndices;

            //找到最大值并且记录所有最大值的位置
            int maxVal = Maxima(testArray, out maxValIndices);
            Console.WriteLine("Maximum value {0} found at element indices:", maxVal);
            foreach (int index in maxValIndices)
            {
                Console.WriteLine(index);
            }
                Console.ReadKey();
        }
        static int Maxima(int[] integers, out int[] indices)
        {
            Debug.WriteLine("Maximum value search started.");
            indices = new int[1];
            int maxVal = integers[0];
            indices[0] = 0;
            int count = 1;
            Debug.WriteLine(string.Format( "Maximum value initialized to {0}, at element index 0.", maxVal));
            for (int i = 1; i < integers.Length; i++)
            {
                Debug.WriteLine(string.Format("Now looking at element at index {0}.", i));
                if (integers[i] > maxVal)
                {
                     maxVal = integers[i];
                     count = 1;
                     indices = new int[1];
                     indices[0] = i;
                     Debug.WriteLine(string.Format( "New maximum found. New value is {0}, at element index {1}.", maxVal, i));
                }
                else
                {
                    if (integers[i] == maxVal)
                    {
                          count++;
                          int[] oldIndices = indices;
                          indices = new int[count];
                          oldIndices.CopyTo(indices, 0);
                          indices[count - 1] = i;
                          Debug.WriteLine(string.Format(
                          "Duplicate maximum found at element index {0}.", i));
                     }
                }
            }
            Trace.WriteLine(string.Format(
            "Maximum value {0} found, with {1} occurrences.", maxVal, count));
            Debug.WriteLine("Maximum value search completed.");
            return maxVal;
        }
    }
}
