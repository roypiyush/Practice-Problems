#include <iostream>

using namespace std;

int calculatePerimeter(char *land[], int si, int sj, int di, int dj) {

    if(si >= di || sj >= dj) {
        return -1;
    }

    for(int i = 0; i <= di; i++) {
        cout<<"-> "<<land[i];
    }

    int mi = (si + di)/2;
    int mj = (sj + dj)/2;

    int c1 = calculatePerimeter(land, si, sj, mi, mj);
    int c2 = calculatePerimeter(land, si, mj, mi, dj);
    int c3 = calculatePerimeter(land, mi, sj, di, mj);
    int c4 = calculatePerimeter(land, mi, mj, di, dj);

    bool correct = true;
    for(int k = sj; k <= dj; k++) {
        if(land[si][k] == 'X') {
            correct = false;
            break;
        }
    }

    for(int k = sj; correct != false && k <= dj; k++) {
        if(land[di][k] == 'X') {
            correct = false;
            break;
        }
    }

    for(int k = si; correct != false && k <= di; k++) {
        if(land[k][sj] == 'X') {
            correct = false;
            break;
        }
    }

    for(int k = si; correct != false && k <= di; k++) {
        if(land[k][dj] == 'X') {
            correct = false;
            break;
        }
    }

    int max = c1 > c2 ? c1 : c2;
    max = c3 > max ? c3 : max;
    max = c4 > max ? c4 : max;
    
    if(correct) {
        int l = dj - sj;
        int b = di - si;
        max = 2 * (l + b);
    }

    return max;

}

int main() {

    int m, n;
    cin>>m>>n;

    char *land[m];
    for(int i = 0; i < m; i++) {
        land[i] = new char;
        cin>>land[i];
    }

    cout<<calculatePerimeter(land, 0, 0, m - 1, n - 1)<<endl;

    return 0;
}
