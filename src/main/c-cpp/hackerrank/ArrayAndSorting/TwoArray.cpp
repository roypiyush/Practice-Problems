#include <iostream>
#include <algorithm>

using namespace std;

bool wayToSort(int i, int j) { return i > j; }

void process(long A[], long B[], int N, long K) {

    sort(A, A + N);
    sort(B, B + N, wayToSort);

    for(int i = 0; i < N; i++) {
        if(A[i] + B[i] < K) {
            cout<<"NO"<<endl;
            return;
        }
    }

    cout<<"YES"<<endl;
}

int main() {

    int T;
    cin>>T;

    while(T--) {

        int N;
        cin>>N;
        long K;
        cin>>K;

        long A[N], B[N];
        for(int i = 0; i < N; i++) {
            cin>>A[i];
        }

        for(int i = 0; i < N; i++) {
            cin>>B[i];
        }

        process(A, B, N, K);

    }

    return 0;
}
