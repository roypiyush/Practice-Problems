#include <iostream>

using namespace std;

void printArray(int arr[], int size) {
    
    for(int i = 0; i < size; i++) {
        cout<<arr[i];
        if(i + 1 != size)
            cout<<", ";
    }
    cout<<"\n";

}


int memoized(int p[], int n)
{

    int s[11] = {0};
    int r[11] ;
    r[0] = 0;
    for(int k=1; k < 11; k++)
	r[k] = -1;


    for(int j=1; j<=n; j++)
    {
	int q = 0;
	for(int i = 1; i<=j; i++)
	{
	    if(q < p[i] + r[j-i]) {
		q = p[i] + r[j-i];
                s[j] = i;
            }
	}
	r[j] = q;
    }

    cout<<"Printing revenue: ";
    printArray(r, 11);
    cout<<"Printing Cuts: ";
    printArray(s, 11);
    return r[n];
}


int main(int argc, char* argv[])
{
    int P[11] = {0,1,5,8,9,10,17,17,20,24,30};

    cout<<memoized(P, 10)<<endl;
    
    return 0;
}
