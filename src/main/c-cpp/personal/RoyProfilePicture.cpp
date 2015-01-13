#include <iostream>

using namespace std;

int main() {

    int L, T;
    cin>>L>>T;
    while(T--) {

        int W, H;
        cin>>W>>H;
        if((W == L && H == L) || (W == H && W >= L)) {
            cout<<"ACCEPTED"<<endl;
        }
        else if(W < L || H < L) {
            cout<<"UPLOAD ANOTHER"<<endl;
        }
        else {
            cout<<"CROP IT"<<endl;
        }
    }

    return 0;
}
