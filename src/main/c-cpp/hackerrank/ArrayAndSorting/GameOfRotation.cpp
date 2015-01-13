#include <iostream>

using namespace std;

long long int sumRotation(long A[], long element, long long int sum1, long long int sum, long n) {

    return (sum1 - sum + n * A[element]);

}


int main() {

    long N;
    cin>>N;

    long A[N];
    long long int sum = 0;
    long long int sum1 = 0;
    for(long i = 0; i < N; i++) {
        cin>>A[i];
        sum += A[i];
        sum1 += (i + 1) * A[i];
    }

    if(N == 1) {
        cout<<sum<<endl;
        return 0;
    }
    else if(N == 2) {
        if(sum1 > (A[1] + 2 * A[0]))
            cout<<sum1<<endl;
        else
            cout<<(A[1] + 2 * A[0])<<endl;

        return 0;
    }

    long long int maxSum = sum1;

    // Element that will be put to last
    long e = 0;
    while(e < N ) {
        sum1 = sumRotation(A, e, sum1, sum,  N);

        if(sum1 > maxSum)
            maxSum = sum1;
        e += 1;
    }

    cout<<maxSum<<endl;

    return 0;

}
