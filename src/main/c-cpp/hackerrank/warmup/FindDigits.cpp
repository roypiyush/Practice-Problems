#include <iostream>
#include <cstring>
#include <string>
#include <cstdlib>

using namespace std;

void numberCount(long t, string s) {

    int length = s.length();

    int count = 0;
    long digits[10] = {};

    for(int i = 0; i < length; i++) {
        char c = s.at(i);
        long v = ((long)c) - 48;
        digits[v] = digits[v] + 1;
        //cout<<digits[v]<<endl;
    }

    for(int i = 1; i < 10; i++) {
        if(digits[i] > 0) {
            
            if((t % i) == 0)
                count++;

        }
    }

    cout<<count<<endl;
}

int main() {

    int T;
    long t;
    string s;

    cin>>T;
    cin>>s;

    t = atol(s.c_str());

    while(T--) {
        numberCount(t, s);
    }

    return 0;
}
