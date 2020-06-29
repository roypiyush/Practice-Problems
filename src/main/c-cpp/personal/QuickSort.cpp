#include <iostream>

using namespace std;

void quickSort(int A[], int p, int r);
int partition(int A[], int p, int r);

void printArray(int A[])
{
    int size = sizeof(A);
    cout<<"Size : "<<size<<endl;
    for(int k = 0;k<size;k++)
        cout<<A[k]<<",";

    cout<<endl;
}

int main(int argc, char* argv[])
{
    int A[] = {2,8,7,1,3,5,6,4};

    printArray(A);

    quickSort(A,0,7);


    printArray(A);
    return 0;

}


void quickSort(int A[], int p, int r)
{
    if(p < r)
    {
	int q = partition(A,p,r);
	quickSort(A,p,q - 1);
	quickSort(A,q + 1,r);
    }
}

int partition(int A[], int p, int r)
{
    int pivot = A[r];
    int i = p - 1;

    for(int j = p; j <= r - 1;j++)
    {
	if(A[j] <= pivot)
	{
	    i = i + 1;
	    int temp  = A[i];
	    A[i] = A[j];
	    A[j] = temp;
	    printArray(A);
	}
    }
    int temp = A[r];

    A[r] = A[i + 1];
    A[i + 1] = temp;
    printArray(A);
    return i + 1;

}
