#include<iostream>
using namespace std;
int main()
{
	while (true)
	{
		char c = getchar();
		if (c != '\n')
		{
			putchar(c);
		}
	}
	
	return 0;
}