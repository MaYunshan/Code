#include<iostream>
#include<regex>
#include<string>

using namespace std;
//2.������ʽ���:
//regex:���ڱ�ʾһ��������ʽ
//regex_match : ��һ���ַ�������һ��������ʽƥ��
//regex_search : Ѱ�ҵ�һ����������ʽƥ���������
// regex_replace : ʹ�ø�����ʽ�滻һ��������ʽ
// sregex_iterator : ������������������regex_search������һ��string������ƥ����ִ�
// smatch : �����࣬������string�������Ľ��
//ssub_match : string��ƥ����ӱ��ʽ�Ľ��

//regex�ļ��е�һЩ���� :
//typedef basic_regex<char> regex;
//typedef basic_regex<wchar_t> wregex;
//typedef match_results<const char *> cmatch;
//typedef match_results<const wchar_t *> wcmatch;
//typedef match_results<string::const_iterator> smatch;
//typedef match_results<wstring::const_iterator> wsmatch;
int main()
{

	//+Ϊ����ƥ��
	//��Դ�ַ�����Ѱ��ָ����ʽ���ַ�������������ص�һ��string��������
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




	//������һ��ȫ��ƥ�䣬�������ַ���Ҫ��ƥ��ģʽ���ַ����ĸ�ʽ��ȫһ��
	
	/*string str = "sigalhu233sss";
	
	smatch sm;
	regex("([a-z]+)(\\d+)([a-z]+)")�ĸ�ʽΪ��ĸ+����+��ĸ�ĸ�ʽ��str����Ҫ��ƥ����Ϊ��
	
	if (regex_match(str.cbegin(), str.cend(), sm, regex("([a-z]+)(\\d+)([a-z]+)")))
	{
		cout << "�ַ�����" << &str[5] << " ƥ��ɹ���" << endl;
		cout << "ƥ���ַ���������" << sm.size() << endl;
		cout << "�ֱ�Ϊ��";
		for (auto aa : sm)
			cout << aa.str() << " ";
		cout << endl;
	}
	else
		cout << "�ַ�����" << &str[5] << " ƥ��ʧ�ܣ�" << endl;*/
}