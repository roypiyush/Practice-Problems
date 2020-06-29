#include <iostream>
#include <algorithm>

using namespace std;

int main(void) {

    int N, K;
    cin >> N >> K;
    long C[N], R[N];

    for(int i = 0; i < N; i++) {
        cin >> C[i];
    }

    sort(C, C + N);
    long result = 0;

    for(int i = N - 1, k = 0; i >= 0; i--, k++) {
        int x = k/K;
        result += ((x + 1) * C[i]);
    }

    cout << result << "\n";

    return 0;

}
