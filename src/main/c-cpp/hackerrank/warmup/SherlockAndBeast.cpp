#include <iostream>

using namespace std;

void printFive(long k) {

    for(long i = 0; i < k; i++) {
        cout<<"5";
    }
}

void printThree(long k) {

    for(long i = 0; i < k; i++) {
        cout<<"3";
    }
}


void process(long N) {

    long fivesCount = 0;
    long threesCount = 0;

    for(long i = 0; i <= N; i++) {
        int r = N - i;
        if(((i % 3) == 0) && (r < 0 ? r = 0 : ((r % 5) == 0))) {
            fivesCount = i;
            threesCount = r;
        }
    }

    if(fivesCount == 0 && threesCount == 0) {
        cout<<"-1"<<endl;
        return;
    }

    printFive(fivesCount);
    printThree(threesCount);
    cout<<endl;
}

int main() {

    int T;
    cin>>T;

    while(T--) {
        long N;
        cin>>N;
        process(N);
    }

    return 0;
}
