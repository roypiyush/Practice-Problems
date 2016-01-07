#include <cmath>
#include <cstdio>
#include <vector>
#include <map>
#include <set>
#include <unordered_set>
#include <string>
#include <climits>
#include <iostream>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
using namespace std;

int dp(vector<int> &in, int m)
{
    int ret = 0;
    size_t len = in.size();

    vector<int> dp(len, 0);

    for (int ilen = 1; ilen <= len; ilen ++)
    for (int i = 0; i <= len - ilen; i++)
    {
        dp[i] += in[i + ilen - 1];
        ret = std::max(ret, dp[i] % m);
    }
    return ret;
}

int main()
{
    int t; cin >> t;
    while (t--)
    {
        long long n, m; cin >> n >> m;
    
        long long x, prefix = 0, ret = 0;
        set<long long> s;
        s.insert(0);
        for (int i = 0; i < n; i++)
        {
            cin >> x;
            prefix = (prefix + x) % m;
            
            //    Case 1: prefix - 0 
            //        (for smaller prefixes)
            ret = std::max(ret, prefix); 

            //    Case 2: prefix - smallest_larer + m 
            //        (for larger prefixes)
            auto it = s.lower_bound(prefix + 1);
            if (it != s.end())
            {
                ret = std::max(ret, prefix - *it + m);
            }

            s.insert(prefix);
        }
        cout << ret << endl;
    }
    return 0;
}
