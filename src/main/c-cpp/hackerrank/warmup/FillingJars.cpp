#include <iostream>

using namespace std;

int main() {

    long N, M;
    cin>>N>>M;

    long long total = 0;
    while(M--) {

        long long a, b, k;
        cin>>a>>b>>k;

        total += (b - a + 1) * k;
    }

    cout<<total/N;

    return 0;
}
