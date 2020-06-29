#include <iostream>
#include <vector>

using namespace std;

int main()
{
	vector<int> fib;
	fib.push_back(0);
	fib.push_back(1);
	
	cout<<fib[0]<<", "<<fib[1]<<", ";
	for(int i = 2; i < 50; i++)
	{
		int nextFib = fib[i-1] + fib[i-2];
		cout<<nextFib<<", ";
		fib.push_back(nextFib);
	}
	return 0;
}
