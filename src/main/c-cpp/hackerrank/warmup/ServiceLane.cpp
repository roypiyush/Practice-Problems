#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {

    int asize, t;
    cin>>asize>>t;
    vector<long> av (asize);    
    
    long i, j = 0;
    while(asize -- > 0) {
        cin>>i;
        av.at(j++) = i;
    }

    while(t-- > 0) {
        long s, e;
        cin>>s>>e;

        long m = 100000;
        while(s <= e) {
            m = min(m, av.at(s));
            s++;
        }
        cout<<m<<endl;
    } 
}
