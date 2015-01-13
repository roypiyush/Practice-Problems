#include <iostream>
#include <set>

using namespace std;

int main()
{
    int N;
    cin>>N;
    multiset<long long> even;
    multiset<long long>::iterator evenit;
    multiset<long long> odd;
    multiset<long long>::reverse_iterator oddit;
    while(N--) {
        long long num;
        cin>>num;
        if(num % 2 == 0) {
            even.insert(num);
        }
        else {
            odd.insert(num);
        }
    }

    for (evenit=even.begin(); evenit!=even.end(); ++evenit)
        cout << ' ' << *evenit;
    cout << '\n';
    for (oddit=odd.rbegin(); oddit!=odd.rend(); ++oddit)
        cout << ' ' << *oddit;
    return 0;
}
