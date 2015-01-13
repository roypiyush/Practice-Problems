#include <iostream>

using namespace std;

int main(int argc,char* argv[])
{
	int a = 10;
	cout<<"Printing address of a=10 ["<<&a<<"]"<<endl;

	int *b;
	b = &a + 1;
	cout<<"Checking arbitrary value "<<*b<<" at "<<b<<endl;
	
}
