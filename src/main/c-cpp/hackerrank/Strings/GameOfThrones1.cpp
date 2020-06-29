#include <iostream> 
#include <cstring>

using namespace std;

int main() {

    char *str = new char;
    cin>>str;

    int size = strlen(str);
    int chars[26];

    for(int i = 0; i < 26; i++) {
        chars[i] = 0;
    }

    for(int i = 0; i < size; i++) {
        int c = str[i] - 97;
        chars[c] = chars[c] + 1; 
    }

    int odd = 0, even = 0;
    for(int i = 0; i < 26; i++) {
        if(chars[i] > 0) {
            if(chars[i] % 2 == 0) 
                even++;
            else
                odd++;
        }
    }

    if(even >= 0 && odd <= 1)
        cout<<"YES";
    else
        cout<<"NO";

    cout<<endl;

    return 0;
}
