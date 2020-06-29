#include <iostream>
#include <vector>
#include <set>
#include <algorithm>

using namespace std;

bool isPermissible(vector<long> a, long d) {
    long cur = 0;
    for(int i = 0; i < a.size(); i++) {
        if(cur + a[i] > d)
            return false;

        cur += a[i];

        if(cur == d) 
            cur = 0;
    }
    return cur == 0;
}

int main() {

    int n;
    cin>>n;

    vector<long> a(n);
    vector<long> r;

    long maxV = -1, sum = 0;
    for(int i = 0; i < n; i++) {
        int v;
        cin>>v;
        if(maxV == -1)
            maxV = v;
        sum += v;
        if(v > maxV) {
            maxV = v;
        }
        a.at(i) = v;
    }

    for(long d = 1; d * d <= sum; d++) {
        if(sum % d == 0) {

            if(isPermissible(a, d)) {
                r.push_back(d);
            }
            if(isPermissible(a , sum/d)) {
                r.push_back(sum/d);
            }
        }
    }

    sort(r.begin(), r.end());

    for(int k = 0; k < r.size(); k++) {
        cout<<r[k]<<" ";
    }
    return 0;
}
