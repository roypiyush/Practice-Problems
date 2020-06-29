#include <iostream>
#include <vector>
#include <algorithm>
#include <functional>

using namespace std;

void calculate(int packets[], int n, int k) {

    sort(packets, packets + n);

    int minUnfairness = packets[n - 1];
    for(int i = 0; (i + k - 1) < n; i++) {
        if((packets[i + k - 1] - packets[i]) < minUnfairness) {
            minUnfairness = packets[i + k - 1] - packets[i];
        }
    }
    cout<<minUnfairness<<endl;
}


int main() {

    int N, K;
    cin>>N;
    cin>>K;

    int packets[N];
    int i = 0;
    while(i < N) {
        int p;
        cin>>p;
        packets[i++] = p;
    }

    calculate(packets, N, K);

    return 0;
}
