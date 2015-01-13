#include <iostream>

using namespace std;

int min(int v1, int v2)
{
	if(v1 < v2)
		return v1;
        else
	        return v2;
}
	

int MIN_COINS_TOP_DOWN(int S, int V[],int lengthOfArray, int R[])
{
	if(R[S] >= 0)
		return R[S];

	int m = S;

	for(int i = 0 ; i < lengthOfArray; i++)
	{
		int STemp = S - V[i];
		if(STemp >= 0)
		{
			int M = MIN_COINS_TOP_DOWN(STemp, V, lengthOfArray, R);
			m = min(M, m);
		}
	}

	if(m == S)
		return S;

	R[S] = m + 1;	

	return R[S];
}


int main(int argc, char* argv[])
{
	int S = 17;

	int V[] = {1,2,5,8};

	int lengthOfArray = sizeof(V)/sizeof(int);

	int R[18] = {-1};
	R[0] = 0;
	for(int i = 1; i < 18; i++)
		R[i] = -1;

	int number = MIN_COINS_TOP_DOWN(S, V, lengthOfArray, R);

	cout<<"Number of coins: "<<number<<endl;

	return 0;
}
