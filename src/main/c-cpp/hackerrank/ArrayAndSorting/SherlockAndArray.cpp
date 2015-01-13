#include <iostream>

using namespace std;

void process(long A[], int N) {

    int i = 0, j = N - 1;

    long sumL = A[i], sumR = A[j];
    while(i + 2 <= j) {

        if(j - i == 2) {
            if(sumL == sumR)
                cout<<"YES"<<endl;
            else
                cout<<"NO"<<endl;
            return;
        }
        else if(j - i > 2) {
            if(sumL <= sumR) {
                sumL += A[++i];
            }
            else {
                sumR += A[--j];
            }
        }
        else {
            break;
        }

    }

    if(N == 1)
        cout<<"YES"<<endl;
    else if(N == 2)
        cout<<"NO"<<endl;
}

int main() {

    int T;
    cin>>T;

    while(T--) {

        int N;
        cin>>N;
        long A[N];
        for(int i = 0; i < N; i++) {
            cin>>A[i];
        }

        process(A, N);
    }

    return 0;
}
