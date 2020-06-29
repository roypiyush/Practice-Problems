#include <iostream>

using namespace std;

void isFibo(long n) {

    long n1 = 0, n2 = 1;

    if(n == n1 || n == n2) {
        cout<<"IsFibo"<<endl;
        return;
    }

    while(1) {

        long t = n1 + n2;
        if(t == n) {
            cout<<"IsFibo"<<endl;
            return;
        }
        else if(t > n) {
             cout<<"IsNotFibo"<<endl;
             return;
        }
        n1 = n2;
        n2 = t;
    }
}

int main() {

    int T; cin>>T;

    while(T--) {
        long N; cin>>N;
        isFibo(N);
    }

    return 0;
}
