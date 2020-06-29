#include <iostream>
#include <cmath>

using namespace std;

int main() {

    string message; cin>>message;

    int length = message.length();
    double root = sqrt(length);

    int row = floor(root);
    int col = ceil(root);

    if(row * col < length) {
        row++;
    }

    for(int c = 0; c < col; c++) {
        for(int r = 0; r < row; r++) {
            int pos = c + r*col;
            if(pos < length)
                cout<<message.at(pos);
        }
        cout<<" ";
    }
    
    return 0;
}
