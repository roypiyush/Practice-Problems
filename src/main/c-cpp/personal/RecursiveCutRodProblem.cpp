#include <iostream>

using namespace std;

int max(int n1, int n2)
{
    if(n1 > n2)
	return n1;
    else
	return n2;
}

int cutrod(int p[], int n)
{
    if(n == 0)
	return 0;
    
    int maxvalue = 0;
    int i;

    for(i=1; i<=n; i++)
    {
	maxvalue = max(maxvalue, p[i] + cutrod(p, n-i));
    }

    return maxvalue;
}

int main(int argc, char* argv[])
{
    int P[11] = {0,1,5,8,9,10,17,17,20,24,28};

    cout<<cutrod(P, 10)<<endl;
    
    return 0;
}
