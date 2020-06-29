#include <iostream>
#include <vector>
#include <set>
#include <cstdlib>

using namespace std;

int main() {

    string testNo;
    getline(cin, testNo);

    int t = atoi(testNo.c_str());
    vector< set<char> > av (t);

    int j = 0;
    while(j < t) {
        string word;
        getline(cin, word);

        set<char> uniqueLetters;
        //set<int>::iterator it;

        for(int i = 0; i < word.length(); i++) {
            uniqueLetters.insert(word.at(i));
        }

        av.at(j++) = uniqueLetters;
    }

    int charCountArray[26] = {};
    j = 0;
    while(j < av.size()) {
        
        set<char> word = av.at(j);
        for (set<char>::iterator it=word.begin(); it!=word.end(); ++it) {
            int i = *it;
            charCountArray[i -97] = charCountArray[i -97] + 1;
        }
        j++;
    }

    int gems = 0;
    for(int i = 0; i < 26; i++) {
        if(charCountArray[i] == t)
            ++gems;
    }
    cout<<gems;
    return 0;

}

