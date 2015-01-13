#include <iostream>
#include <csignal>

using namespace std;

int max(int n1, int n2);
int findLengthOfMaximumDensity(int P[],int size, int length);
int greedyCutRod(int p[], int n);


int max(int n1, int n2) {
    if(n1 > n2)
	return n1;
    else
	return n2;
}

int greedyCutRod(int p[], int n) {
    int maxPrice = 0;
    
    while(n > 0) {
        int length = findLengthOfMaximumDensity(p, 11, n);
        maxPrice = maxPrice + p[length];
        n = n - length;
    }

    return maxPrice;
}

int findLengthOfMaximumDensity(int P[],int size, int length) {

    float maxDensity = 0.0;
    int l = 0;
    for(int i = length; i < size && i > 0; i--) {
        if(P[i]/i > maxDensity) {
            maxDensity = P[i]/i;
            l = i;
        }
    }

    return l;
}

int main(int argc, char* argv[])
{
    int P[11] = {0,1,5,8,12,10,17,17,20,24,28};

    cout<<greedyCutRod(P, 10)<<endl;
    
    return 0;
}
