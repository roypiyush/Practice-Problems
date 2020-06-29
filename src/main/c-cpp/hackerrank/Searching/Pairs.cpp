#include <iostream>
#include <cmath>

using namespace std;

int main() {

    int N; cin>>N;
    long K; cin>>K;
    float l1 = pow(2, 31);

    const long l = (long) l1;

    int *A;
    A = new int[l];

    while(N--) {
        int v; cin>>v;
        A[v] = A[v] + 1;
    }

    long count = 0;
    for(int i = 1; i < l - 1; i++) {
        if(A[i] == 1 && A[i+K] == 1) {
            count++;
        }
    }

    cout<<count<<endl;
    return 0;
}
