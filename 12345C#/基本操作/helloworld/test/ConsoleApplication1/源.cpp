#include <iostream>
#include <stdio.h>

using namespace std;

void main()
{
	int i, n;
	n = 0;
	char s[] = { '1', 2, 3, 4, 5, 6 };
	for (i = 0; s[i] >= '0'&&s[i] <= '9'; ++i)
	{
		n = 10 * n + (s[i] - '0');
		cout << n << endl;
	}
	cout << n << endl;
	system("pause");
	return;

}