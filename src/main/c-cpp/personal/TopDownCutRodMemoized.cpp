#include <iostream>

using namespace std;

int max(int n1, int n2)
{
    if(n1 > n2)
	return n1;
    else
	return n2;
}


int memoized_aux(int p[], int n, int r[])
{
    int q = 0;
    if(r[n] >= 0)
	return r[n];
    else
    {
	//q = -1000;
	for(int i = 1; i<=n; i++)
	{
	    q = max(q, p[i] + memoized_aux(p, n-i, r));
	}
    }

    r[n] = q;

    return q;
}

int memoized(int p[], int n)
{
    int r[11];
    r[0] = 0;
    for(int i=1; i<=n ; i++)
        r[i] = -1;

    return memoized_aux(p, n, r);

}

int main(int argc, char* argv[])
{
    int P[11] = {0,1,5,8,9,10,17,17,20,24,30};

    cout<<memoized(P, 4)<<endl;
    
    return 0;
}
