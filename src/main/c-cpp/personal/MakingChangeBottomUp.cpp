#include <iostream>

using namespace std;

void MIN_COIN_BOTTOM_UP(int S, int V[], int arrayLength, int R[])
{
	for (int i = 1; i <= S; i++)
	{
		cout << "\ni=" << i << endl;
		int m = i;
		for (int j = 0; j < arrayLength; j++)
		{
			int r = i - V[j];
			cout << "Remainder: " << r << ", i: " << i << ", V["<< j << "]: " << V[j] << endl;
			if (r == 0) // Just found the solution
			{
				m = 1;
				R[i] = m;
				break;
			}
			else if (r > -1 && R[r] > -1) // Then solution already exists
			{
				m = R[r] + 1;
			} else if (r > 0)
			{
				m = min(m, R[r]);
			}
			R[i] = m;
		}

		cout << "m=" << m << "," << "R[" << i << "]=" << R[i] << endl;
	}

	cout << "Number of coins: " << R[S] << endl;
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


	MIN_COIN_BOTTOM_UP(S,V,lengthOfArray,R);

	return 0;
}
