#include<iostream>
#include<regex>
#include<string>

using namespace std;
//2.正则表达式组件:
//regex:用于表示一个正则表达式
//regex_match : 将一个字符序列与一个正则表达式匹配
//regex_search : 寻找第一个与正则表达式匹配的子序列
// regex_replace : 使用给定格式替换一个正则表达式
// sregex_iterator : 迭代器适配器，调用regex_search来遍历一个string中所有匹配的字串
// smatch : 容器类，保存在string中搜索的结果
//ssub_match : string中匹配的子表达式的结果

//regex文件中的一些定义 :
//typedef basic_regex<char> regex;
//typedef basic_regex<wchar_t> wregex;
//typedef match_results<const char *> cmatch;
//typedef match_results<const wchar_t *> wcmatch;
//typedef match_results<string::const_iterator> smatch;
//typedef match_results<wstring::const_iterator> wsmatch;
int main()
{

	//+为连续匹配
	//在源字符串中寻找指定格式的字符串，将结果返回到一个string容器类里
	string text = "sigalhu233454545dddddd3344gdgffd";
	regex re("([a-z]+)");
	smatch matches;
	while (regex_search(text, matches, re))
	{
		cout << matches.str()<<endl;
		text = matches.suffix().str();
	    /*string str = matches.str();
	     cout << str;*/
	}




	//下面是一种全文匹配，即输入字符串要和匹配模式的字符串的格式完全一样
	
	/*string str = "sigalhu233sss";
	
	smatch sm;
	regex("([a-z]+)(\\d+)([a-z]+)")的格式为字母+数字+字母的格式，str符合要求，匹配结果为真
	
	if (regex_match(str.cbegin(), str.cend(), sm, regex("([a-z]+)(\\d+)([a-z]+)")))
	{
		cout << "字符串：" << &str[5] << " 匹配成功！" << endl;
		cout << "匹配字符串个数：" << sm.size() << endl;
		cout << "分别为：";
		for (auto aa : sm)
			cout << aa.str() << " ";
		cout << endl;
	}
	else
		cout << "字符串：" << &str[5] << " 匹配失败！" << endl;*/
}