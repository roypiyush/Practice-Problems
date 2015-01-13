#include <iostream>
#define MAX(a,b) (a>b) ? (a) : (b)
using namespace std;

int knapsack(int W[], int V[], int w)
{
	if(w == 0)
		return 0;
	int maxValue = 0;
	
	for(int i=0; i<5; i++)
	{
		int t = w - W[i];
		if(t >= 0)
			maxValue = MAX(maxValue, knapsack(W, V, t) + V[i]); 
	}

	return maxValue;
}

int main(int argc, char* argv[])
{
	int W[5] = {3,5,7,2,6};
	int V[5] = {12,32,23,14,33};
	
	cout<<knapsack(W, V, 17)<<endl;
	
	return 0;
}
