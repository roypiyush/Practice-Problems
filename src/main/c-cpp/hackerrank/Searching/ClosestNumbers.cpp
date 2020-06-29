#include <iostream>
#include <cstdlib>

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


void quickSort(long A[], long p, long r) {

    if(p < r) {
        long q = partition(A, p, r);
        quickSort(A, p, q - 1);
        quickSort(A, q + 1, r);
    }

}

int main() {

    long n;
    cin>>n;

    long A[n];
    for(long i = 0; i < n; i++) {
        cin>>A[i];
    }

    quickSort(A, 0, n - 1);

    long diff = abs(A[n-1] - A[0]);
    for(long i = 0; i < n - 1; i++) {

        if(abs(A[i+1] - A[i]) < diff)
            diff = abs(A[i+1] - A[i]);
    }


    for(long i = 0; i < n - 1; i++) {
        long d = abs(A[i+1] - A[i]);

        if(d == diff) {
            cout<<A[i]<<" "<<A[i+1]<<" ";
        }
    }

    cout<<endl;
    return 0;
}

