#include <iostream>

using namespace std;

int main() {


    int A[101], B[101];
    for(int i = 0; i < 101; i++) {
        A[i] = 0;
        B[i] = 0;
    }

    long n;
    cin>>n;

    int a[n], amin = 0;
    for(int i = 0; i < n; i++) {
        cin>>a[i];

        if(i == 0) {
            amin = a[i];
        }
        else {
            if(amin > a[i])
                amin = a[i];
        }
    }

    // Create A
    for(int i = 0; i < n; i++) {
        A[a[i] - amin] = A[a[i] - amin] + 1;
    }

    cin>>n;
    int b[n], bmin = 0;
    for(int i = 0; i < n; i++) {
        cin>>b[i];

        if(i == 0) {
            bmin = b[i];
        }
        else {
            if(bmin > b[i])
                bmin = b[i];
        }
    }

    // Create B
    for(int i = 0; i < n; i++) {
        B[b[i] - bmin] = B[b[i] - bmin] + 1;
    }


    for(int i = 0; i < 101; i++) {
        if(A[i] != B[i])
            cout<<i+bmin<<" ";
    }
 
    cout<<endl;
    return 0;
}
