#include <iostream>
#include <cstring>
#include <stdlib.h> 

using namespace std;

int main() {
    
    int T; cin>>T;
    for(int i = 0; i < T; i++) {

        char* str;
        str = new char;
        cin>>str;

        bool isFunny = true;
        int len = strlen(str);
        for(int j = 1; j < len; j++) {
            int k = len - j;

            int s2 = (int) str[j];
            int s1 = (int) str[j - 1];

            //cout<<"s2 = "<<s2<<" s1 = "<<s1<<endl;

            int r1 = (int) str[k];
            int r2 = (int) str[k - 1];

            //cout<<"r2 = "<<r2<<" r1 = "<<r1<<endl;

            if(abs(s2-s1) != abs(r2-r1)) {
                isFunny = false;
                break;
            }
        }
        if(isFunny) {
            cout<<"Funny"<<endl;
        }
        else {
            cout<<"Not Funny"<<endl;
        }
    }

    return 0;
}
