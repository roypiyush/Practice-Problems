#include <iostream>
#include <vector>

using namespace std;

#define mod 1000000007;

int main() {

    int N, M;
    cin>>N>>M;

    vector<long> A(N + 1), B(M), C(M);
    A.at(0) = -1;
    int k = 1;
    while(k <= N) {
        int e;
        cin>>e;
        A.at(k++) = e;
    }

    k = 0;
    while(k < M) {
        int e;
        cin>>e;
        B.at(k++) = e;
    }

    k = 0;
    while(k < M) {
        int e;
        cin>>e;
        C.at(k++) = e;
    }


    for(int i = 0; i < M; i++) {
        int v = N / B[i];
        for(int j = 1; j <= v; j++) {
            int aPos = B[i] * j;
            A[aPos] = A[aPos] * C[i];
            A[aPos] = A[aPos] % mod;
        }
    }

    for(int i = 1; i <= N; i++) {
        cout<<A.at(i)<<" ";
    }

    return 0;
}
