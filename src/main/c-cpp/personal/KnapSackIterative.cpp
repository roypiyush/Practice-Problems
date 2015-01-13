#include <iostream>
#include <vector>

#define MAX(a,b) (a>b) ? (a) : (b)

using namespace std;

int knapsack(int W[], int V[], int w)
{
	if(w == 0)
		return 0;
	
	int M[11] = {0};
	
	for(int i=1; i<=w; i++)
	{
		
		M[i] = 0;
		int item = 0;
		for(int j=0; j < 5 && W[j] <= i; j++)
		{
			//M[i] = MAX(M[i], M[i - W[j]] + V[j]);
			if(M[i] < (M[i-W[j]] + V[j]))
			{
				M[i] = M[i-W[j]] + V[j];
				item = j+1;
			}
			
		}
		
		
	}
	
	return M[w];
}


int main(int argc, char* argv[])
{
	int W[5] = {3,4,7,2,6};
	int V[5] = {12,32,23,14,7};
	
	int M = knapsack(W, V, 10);
	
	cout<<endl<<"Maximum value the thief can take is "<<M<<endl;

	
	return 0;
}
