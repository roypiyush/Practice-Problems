#include <iostream>
#include <algorithm>

using namespace std;

int main() { 

    int N, K;
    cin>>N>>K;

    int prices[N];
    int i = 0;
    while(i < N) {
        cin>>prices[i++];
    }

    sort(prices, prices + N);

    int toys = 0;
    for(int i = 0; i < N; i++) {

        if(K - prices[i] >= 0) {
            toys++;
            K = K - prices[i];
        }
        else 
            break;
    }

    cout<<toys;
}
