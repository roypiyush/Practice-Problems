#include <iostream>

using namespace std;


void printMatrix(int m[][3])
{
    for(int i=0; i<3; i++)
    {
	for(int j=0; j<3; j++)
	{
	    cout<<m[i][j]<<",";
	}
	cout<<"\n";
    }
}


int partition(int a[][3], int b[][3], int c[][3], int i, int j)
{


    int C[i][j] = a[i][k] * b[k][j]; 

}


int main(int argc, char* argv[])
{

    int A[][3] = {{1,2,3},{1,2,3},{1,2,3}};
    int B[][3] = {{1,2,3},{1,2,3},{1,2,3}};

    printMatrix(A);

    return 0;
}
