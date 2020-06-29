#include <iostream>
#include <cstring>
#include <climits>

#define min(a, b) a<b?a:b;

using namespace std;

/**
* Calculate Minimum difference remaining for target, S
*/
int multiSum(int S, int arr[], int n, int memoized[]) {

    int minSum = INT_MAX;
    if(S < 0)
        return INT_MAX;
    if(memoized[S] >= 0)
        return memoized[S];

    minSum = S;
    for(int i = 0; i < n; i++) {
        int Sr = S - arr[i];
        int sum = multiSum(Sr, arr, n, memoized);
        minSum = min(minSum, sum);
    }

    if(memoized[S] == -1 || memoized[S] > minSum)
        memoized[S] = minSum;

    return memoized[S];
}


int main() {

    int T;
    cin>>T;
    while(T--) {

        int n, S;
        cin>>n>>S;

        int arr[n];
        for(int i = 0; i < n; i++) {
            cin>>arr[i];
        }

        int memoized[S + 1];
        memset(memoized, -1, sizeof(memoized));
        memoized[0] = 0;

        cout<<(S - multiSum(S, arr, n, memoized))<<endl;

    }

    return 0;
}

