using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Text.RegularExpressions;

namespace 正则表达式定位符
{
    class Program
    {
        static void Main(string[] args)
        {

            #region
            ////在字符串的头部寻找匹配字符【^】
            //string word1 = "year1998 year2008 year2018";
            //Regex ex1=new Regex(@"^year\d\d\d\d");        
            //foreach (Match ma in ex1.Matches(word1))    
            //    Console.WriteLine(ma);                    //输出为year1998
            #endregion

            #region
            ////在字符串的尾部寻找匹配字符【$】
            //string word1 = "year1998 year2008 year2018";
            //Regex ex1 = new Regex(@"year\d\d\d\d$");
            //foreach (Match ma in ex1.Matches(word1))
            //    Console.WriteLine(ma);                     //输出为year2018
            #endregion

            #region
            //string words = "formfordfork";
            //Regex ex2 = new Regex(@"for\w");
            //foreach (Match ma in ex2.Matches(words))
            //    Console.Write(ma + "\t");
            //Console.WriteLine();

            //ex2 = new Regex(@"\bfor\w");
            //foreach (Match ma in ex2.Matches(words))
            //    Console.Write(ma + "\t");
            //Console.WriteLine();

            //ex2 = new Regex(@"for\w\b");
            //foreach (Match ma in ex2.Matches(words))
            //    Console.Write(ma + "\t");
            //Console.WriteLine();


            #endregion

            #region
            ////去掉字符串里的各种符号
            ////------"\b"匹配单词的边界位置
            ////------"\B"不匹配单词的边界位置
            //string words = "are yau ok?";
            //Regex ex2 = new Regex(@"\b\w+\b");      //输出是 are  you   ok
            ////Regex ex2 = new Regex(@"\B\w+\B");     //输出是  r    o  
            //foreach (Match ma in ex2.Matches(words))
            //    Console.WriteLine(ma);
            #endregion


            //分组

            string words = "18191263369@163.com 163";
            //Regex ex = new Regex(@"(\w+)@(\w+)\.(\w+) \2");    //输出是18191263369@163.com 163
            Regex ex = new Regex(@"(\w+)@(\w+)\.(\w+)");       //输出是18191263369@163.com
            Console.WriteLine(ex);
            foreach (Match match in ex.Matches(words))
                Console.WriteLine(match);

            //string word = "are you very very good";

            ////-------[@"\b(\w+)\b \1"]代表"\b(\w+)\b (\w+)"
            ////-------其中\b(\w+)\b代表匹配到的单词，(\w+)代表这个单词
            //foreach (Match match in Regex.Matches(word, @"\b(\w+)\b \1"))
            //    Console.WriteLine(match);
        }
    }
}
