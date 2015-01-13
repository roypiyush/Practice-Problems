#include <iostream>

using namespace std;


int chocolateCount(int N, int C, int M) {

    int count = N / C;

    int wrappers = count;
    while(wrappers / M) {
        int newChocolates = wrappers / M;
        int wrappersLeft = wrappers % M;
        count += newChocolates;

        wrappers = newChocolates + wrappersLeft;
    }

    return count;
}


int main() {

    int T;
    cin>>T;


    while(T--) {

        int N, C, M;
        cin>>N>>C>>M;

        cout<<chocolateCount(N, C, M)<<endl;
    }

    return 0;
}
