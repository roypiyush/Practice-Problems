#include <iostream>
#include <cconio>

using namespace std;

int main(int argc, char* argv[])
{
	cout<<"Press any key to continue"<<endl;
	while(!kbhit());
	return 0;
}
