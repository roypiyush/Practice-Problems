#include <iostream>
#include <algorithm>

using namespace std;

int main() {

    int L,R;
    cin>>L;
    cin>>R;

    int l = min(L, R);
    int r = max(L, R);
    int m = -1;
    for(int i = l; i <= r; i++) {
        for(int j = l; j <= r; j++) {
            m = max(m, i ^ j);        
            cout<<"i = "<<i<<", j = "<<j<<" xor = "<<(i ^ j)<<endl;
        }
    }

    cout<<m<<endl;

    return 0;
}
