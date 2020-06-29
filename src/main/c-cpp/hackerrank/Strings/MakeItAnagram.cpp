#include <iostream>
#include <cstring>
#include <algorithm> 
#include <stdlib.h> 

using namespace std;

int main() {
    
    char *s1, *s2;
    s1 = new char;
    s2 = new char;

    cin>>s1>>s2;

    int s1len = strlen(s1);
    int s2len = strlen(s2);

    int *s1arr = new int[26];
    int *s2arr = new int[26];
    
    fill(s1arr, s1arr + 26, 0);
    fill(s2arr, s2arr + 26, 0);
    
    for(int i = 0; i < s1len; i++) {
        int j = s1[i] - 97;
        s1arr[j] = s1arr[j] + 1;
    }

    for(int i = 0; i < s2len; i++) {
        int j = s2[i] - 97;
        s2arr[j] = s2arr[j] + 1;
    }

    int res = 0;
    for(int i = 0; i < 26; i++) {
        res = res + abs(s1arr[i] - s2arr[i]);
    }

    cout<<res<<endl;

    return 0;
}
