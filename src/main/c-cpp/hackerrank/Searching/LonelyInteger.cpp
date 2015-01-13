#include <iostream>

using namespace std;

int main() {

    int N; cin>>N;
    int A[101] = {};

    while(N--) {
        int v; cin>>v;
        A[v] = A[v] + 1;
    }

    for(int i = 0; i < 101; i++) {
        if(A[i] == 1) {
            cout<<i;
            break;
        }
    }
    return 0;
}
