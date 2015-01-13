#include <iostream>

using namespace std;


void cutPieces(long k) {

    long side = k/2;
    if(k % 2 == 0)
        cout<<side * side<<endl;
    else 
        cout<<side * side + side<<endl;

}

int main() {

    int T;
    cin>>T;

    while(T-- > 0) {
        long k;
        cin>>k;
        cutPieces(k);
    }

    return 0;
}
