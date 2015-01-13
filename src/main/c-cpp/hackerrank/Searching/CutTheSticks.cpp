#include <iostream>
#include <set>

using namespace std;

int main() {

    multiset<int> data;

    int size;
    cin>>size;
    while(size--) {
        int item;
        cin>>item;
        data.insert(item);
    }

    cout<<data.size()<<endl;

    while(data.size() > 0) {
        multiset<int>::iterator it = data.begin();

        int smallest = *it;
        while(it != data.end()) {
            data.erase(it);

            if(*it != smallest) {
                int num = *it;
                data.insert(num - smallest);
            }
            ++it;
        }

        if(data.size() > 0)
            cout<<data.size()<<endl;
    }

    return 0;
}
