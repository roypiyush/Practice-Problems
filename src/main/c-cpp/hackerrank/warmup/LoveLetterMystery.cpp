#include <iostream>
#include <string>
#include <cstdlib>

using namespace std;

int main() {

    string testNo;
    getline(cin, testNo);

    int t = atoi(testNo.c_str());

    while(t-- > 0) {
        string word;
        getline (std::cin,word);
        
        int result = 0;
        int j = word.size() - 1, i = 0;
        while(i < j) {
            int c1 = word.at(i);
            int c2 = word.at(j);
            int c = abs(c1-c2);

            result += c;
            i++;j--;
        }
        cout<<result<<endl;
    }

    return 0;
}
