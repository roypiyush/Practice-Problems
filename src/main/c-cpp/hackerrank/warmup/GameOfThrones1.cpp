#include <iostream>
#include <cstring>

using namespace std;

bool isPalindrome(char *s);

void swap(char *s, int i, int j) {

    char t = s[i];
    s[i] = s[j];
    s[j] = t;
}


void permute(char *s, int i, char *answer) {
    int size = strlen(s);
    if(i == size - 1) {
        if(isPalindrome(s)) {
            strcpy(answer, "YES");
        }
    }
    else {
        for(int j = i; j < size; j++) {
            swap(s, i, j);
            permute(s, i + 1, answer);
            swap(s, i, j);
        }

    }
}

bool isPalindrome(char *s) {

    int size = strlen(s);
    int i = 0, j = size - 1;

    while(i < j) {
        if(s[i] != s[j])
            return false;
        i++;
        j--;
    }
    return true;
}


void isPalindromeExist(char *s) {

    int chars[26] = {};
    int size = strlen(s);
    for(int i = 0; i < size; i++) {
        int c = s[i];
        chars[c - 97] += 1;
    }

    int evenCharsCount = 0;
    int oddCharsCount = 0;

    for(int i = 0; i < 26; i++) {
        if(chars[i] % 2) 
            oddCharsCount++;
        else
            evenCharsCount++;
    }

    if(oddCharsCount > 1)
        cout<<"NO"<<endl;
    else
        cout<<"YES"<<endl;

}

int main() {

    char *s = new char;
    //char *ans = new char;
    //strcpy(ans, "NO");
    cin>>s;
    isPalindromeExist(s);
    //permute(s, 0, ans);
    //cout<<ans<<endl;
    return 0;
}
