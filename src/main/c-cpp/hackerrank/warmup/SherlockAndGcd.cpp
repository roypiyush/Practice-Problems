#include <iostream>
#include <vector>

using namespace std;

int gcd ( int a, int b ) {
    int c;
    while ( a != 0 ) {
        c = a;
        a = b%a;
        b = c;
    }
    return b;
}


void process(const vector<int>& array) {

    int N = array.size();

    int g = array.at(0);
    for(int i = 1; i < N - 1; i++) {
        g = gcd(g , array.at(i));
    }

    if(g > 1) {
        cout<<"NO"<<endl;
        return;
    }
    else {
        cout<<"YES"<<endl;
        return;
    }
}

int main() {

    int T;
    cin>>T;

    while(T--) {

        int N, t;
        cin>>N;
        t = 0;
        vector<int> array(N);
        while(t < N) {
            int e;
            cin>>e;
            array.at(t) = e;
            t++;
        }

        process(array);

    }

    return 0;
}
