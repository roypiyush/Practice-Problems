#include <iostream>
#include <string>

using namespace std;


bool isCavity(string map[], int size, int i, int j) {

    if(((i - 1 < 0) || (i + 1 >= size)) || ((j - 1 < 0) || (j + 1 >= size)))
        return false;

    
    if(map[i - 1].at(j) == 'X' || map[i + 1].at(j) == 'X'
        || map[i].at(j - 1) == 'X' || map[i].at(j + 1) == 'X')
        return false;

    
    if(map[i].at(j) > map[i - 1].at(j) 
    && map[i].at(j) > map[i + 1].at(j)
    && map[i].at(j) > map[i].at(j - 1)
    && map[i].at(j) > map[i].at(j + 1)) {
        return true;
    }
    else {
        return false;
    }
    
}

int main() {

    int N; cin>>N;

    string map[N];
    for(int i = 0; i < N; i++) {
        cin>>map[i];
    }

    for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {

            if(isCavity(map, N, i, j)) {
                map[i].replace(j, 1, "X");
            }
        }
    }


    for(int i = 0; i < N; i++) {
        cout<<map[i]<<endl;
    }
    return 0;
}
