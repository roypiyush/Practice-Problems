#include <iostream>
#include <vector>
#include <set>
#include <algorithm>
#include <cstdlib>

using namespace std;

int main() {

    int N; cin>>N;

    vector<long> a(N);
    for(int i = 0; i < N; i++) {
        cin>>a[i];
    }
    
    long P, Q;
    cin>>P>>Q;

    sort(a.begin(), a.end());

    set<long> minimax;

    minimax.insert(abs(P));
    minimax.insert(abs(Q));

    for(int i = 0; i < N; i++) {
        long p1 = abs(a[i] - 1);
        long p2 = abs(a[i] + 1);
        long q1 = abs(a[i] - 1);
        long q2 = abs(a[i] + 1);
  
        minimax.insert(p1);
        minimax.insert(p2);
        minimax.insert(q1);
        minimax.insert(q2);
        
    }


    set<long>::iterator it; long min = 2147483647;
    for(it = minimax.begin(); it != minimax.end(); ++it) {
        long v = *it;
        if(v >= P && v <= Q && v < min)
            min = v;
    }

    if(min != 2147483647) {
        cout<<min;
        return 0;
    }

    long m1 = abs(P - a[0]);
    long m2 = abs(P - a[N-1]);

    if(m2 < m1)
        m1 = m2;

    long m3 = abs(Q - a[0]);
    long m4 = abs(Q - a[N-1]);

    if(m4 < m3)
        m3 = m4;

    if(m1 < m3)
        cout<<P;
    else
        cout<<Q;
    

    return 0;
}
