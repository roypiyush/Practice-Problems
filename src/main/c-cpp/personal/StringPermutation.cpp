#include <iostream>
#include <cstring>
#include <cstdlib>

using namespace std;

void assignArray(char newArr[], char oldArr[])
{
	int size = sizeof(oldArr)/sizeof(char);
	for(int i = 0;i < size;i++)
        {
        	newArr[i] = oldArr[i];
	}

}

int factorial(int number)
{
	if(number == 1 || number == 0)
	{
		return number;
	}
	else
		return number * factorial(number - 1);
}

void swap(char arr[],int i, int j)
{
	char t = arr[i];
	arr[i] = arr[j];
	arr[j] = t;
	//cout<<arr<<endl;
}


int main(int argc, char* argv[])
{
	//char c[4] = {'a','b','c','\0'};
	char c[] = "abc";

	int size = sizeof(c)/sizeof(char) - 1;

	cout<<"Size : "<<size<<endl;

	cout<<"Factorial of "<<size<<" is " <<factorial(size)<<endl;

	for(int i = size ; i > 0 ;i--)
	{
		int index = 0;
		do
		{
			swap(c,index,i-1);
			cout<<c<<endl;
			index++;
		}while(index < size - 1 );
	}

	return 0;
}

