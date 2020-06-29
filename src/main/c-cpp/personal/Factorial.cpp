#include <iostream>

using namespace std;

int factorial(int number)
{
	if(number == 1 || number == 0)
	{
		return number;
	}
	else
		return number * factorial(number - 1);
}

int main(int argc, char* argv[])
{
	int number = 5;
	cout<<"Factorial of "<<number<<" is "<<factorial(number)<<endl;
}
