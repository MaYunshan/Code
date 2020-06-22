using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Text.RegularExpressions;
using System.IO;

namespace 匹配查找
{
    class Program
    {
        static void Main(string[] args)
        {

            #region
            //string text = "The Colony is a beautify Room212 town...Kitty lives in Room415";
            //Regex expression = new Regex(@"s2[i]");
            //MatchCollection match = expression.Matches(text);

            //foreach (Match mat in match)
            //    Console.WriteLine(mat);

            //Match match1 = expression.Match(text);
            //Console.WriteLine(match1);
            //Console.WriteLine(match1.NextMatch());
            //bool bMatch = expression.IsMatch(text);
            //Console.WriteLine(bMatch);
            //string path=(@"say ""hello"" to you");
            //Console.WriteLine(path);
            #endregion

            //string text = "他在Warren McCulLocH和WaLter PiTts早期工作的基础之上，发表了一篇";
            //Regex ex = new Regex(@"[a-z][A-Z]");
            //foreach (Match match in ex.Matches(text))
            //    Console.WriteLine(match);

            string path=@"D:\12345C#\正则表达式\file1.txt";

            StreamReader sReader = new StreamReader(path);
            string text = sReader.ReadToEnd();
            Console.WriteLine(text);

            Regex ex = new Regex(@"[0-9][0-9]");
            foreach (Match match in ex.Matches(text))
                Console.WriteLine(match);
        }
    }
}
