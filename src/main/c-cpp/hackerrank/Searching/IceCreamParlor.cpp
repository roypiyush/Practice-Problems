#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

struct IceCream {
    int index;
    int cost;
};

bool byCost(const IceCream &i1, const IceCream &i2) {

    return i1.cost < i2.cost;
}

void process(vector<IceCream> icv, int N, int M) {

    int i = 0, j = N - 1;

    while(i < j) {
        if(M > icv[i].cost + icv[j].cost)
            i += 1;
        else if(M < icv[i].cost + icv[j].cost)
            j -= 1;
        else {
            if(icv[i].index < icv[j].index) {
                cout<<(icv[i].index + 1)<<" "<<(icv[j].index + 1)<<endl;
            }
            else {
                cout<<(icv[j].index + 1)<<" "<<(icv[i].index + 1)<<endl;
            }
            break;
        }

    }

}

int main() {

    int T; cin>>T;
    while(T--) {

        int M; cin>>M;
        int N; cin>>N;

        vector<IceCream> icv(N);
        for(int i = 0; i<N; i++) {
            cin>>icv[i].cost;
            icv[i].index = i;
        }

        sort(icv.begin(), icv.end(), byCost);
        process(icv, N, M);
    }

    return 0;
}
