#include <ctime>
#include <iostream>
#include <cstdlib>

using namespace std;

int main(int argc,char* argv[])
{

	cout<<"Hello, "<<getenv("LOGNAME")<<endl;
	for(int i=0; i<1000; i++)
	{
		cout<<"";
	}
	cout<<"Clock ticks: "<<clock()<<" Seconds: "<<clock()/CLOCKS_PER_SEC<<endl;

	time_t hold_time;
	hold_time=time(NULL);
	cout<<"The date is: "<<ctime(&hold_time)<<endl;
}
