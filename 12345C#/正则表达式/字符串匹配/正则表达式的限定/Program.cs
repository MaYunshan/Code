using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Text.RegularExpressions;

namespace 正则表达式的限定
{
    class Program
    {
        static void Main(string[] args)
        {
            #region

            //声明一个源字符串
            //string word = "lg log loog looog loooooog looooooooog";
            ////新建一个匹配字符对象
            //Regex ex1 = new Regex("log");
            //MatchCollection matches = ex1.Matches(word);
            //foreach (Match match in matches)
            //    Console.WriteLine(match);
            #endregion

            #region

            ////声明一个源字符串
            //string word = "lg log loogfg looog loooooog looooooooog";
            ////新建一个匹配字符对象---匹配单个字符------各种数量限定符
            ///*********************************************************
            // * ---------"c*"代表符号c前面0个或者多个字符
            // * ---------"c+"代表符号c前面一个或者多个字符
            // * ---------"c？"代表符号c前面一个或者0个字符
            // * ---------"c{n}"代表符号c前面的字符重复n次
            // * ---------"c{m,n}"代表符号c前面的字符重复m到n次
            // */
            //Regex ex1 = new Regex("lo?g");
            //MatchCollection matches = ex1.Matches(word);
            //foreach (Match match in matches)
            //    Console.WriteLine(match);
            #endregion

            #region
            ////声明一个源字符串
            //string word = "lg leog leoeog leooeog leogooooeog leoeoeoeoeog";
            ////新建一个匹配字符对象---匹配多个字符------各种数量限定符
            ///*********************************************************
            // * ---------"str*"代表符号c前面0个或者多个字符
            // * ---------"str+"代表符号c前面一个或者多个字符
            // * ---------"str？"代表符号c前面一个或者0个字符
            // * ---------"str{n}"代表符号c前面的字符重复n次
            // * ---------"str{m,n}"代表符号c前面的字符重复m到n次
            // */
            //Regex ex1 = new Regex("l(eo)+g");
            //MatchCollection matches = ex1.Matches(word);
            //foreach (Match match in matches)
            //    Console.WriteLine(match);
            #endregion

            #region

            //通配符和限定符的组合   
            string girls = "Van is 18; Victy is 16; Vinect is 19";
            Regex ex1 = new Regex(@"V\w* is \d\d");
            foreach (Match match in ex1.Matches(girls))
                Console.WriteLine(match);
            #endregion
        }
    }
}
