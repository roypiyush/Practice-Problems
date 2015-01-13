#include <iostream>

using namespace std;

long partition(long A[], long p, long r) {
    long pivot = A[r];
    long i = p - 1;

    for(long j = p; j <= r - 1; j++) {
        if(A[j] <= pivot) {
            i = i + 1;
            long temp  = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }
    long temp = A[r];

    A[r] = A[i + 1];
    A[i + 1] = temp;
    return i + 1;
}

int main() {

    long n;
    cin>>n;

    long A[n];
    for(long i = 0; i < n; i++) {
        cin>>A[i];
    }

    long s = 0, e = n - 1, r = n/2, index = n;
    while(index != r) {

        if(index > r) {
            e = index - 1;
        }
        else {
            s = index + 1;
        }
        index = partition(A, s , e);
    }

    cout<<A[index]<<endl;

    return 0;
}
