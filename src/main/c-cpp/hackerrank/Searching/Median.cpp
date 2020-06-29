#include <iostream>
#include <set>
#include <cstdlib>
#include <cstdio>

using namespace std;

class SortedElements {

private:
    multiset<long> left;
    multiset<long> right;

public:
    long size() {
        return left.size() + right.size();
    }

    bool isEmpty() {
        return (size() == 0);
    }

    void insert(long item) {

        // cout<<"Calling Insert \n";

        if(size() == 0) {
            left.insert(item);
            return;
        }

        if(left.size() == right.size())
            left.insert(item);
        else
            right.insert(item);

        long l = *left.rbegin();
        long r = *right.begin();

        if(l > r) {
            left.insert(*right.begin());

            //cout<<"L: "<<*left.rbegin()<<endl;
            //cout<<"R: "<<*right.begin()<<endl;

            if(left.size() > right.size() + 1) {
                right.insert(*left.rbegin());
                left.erase(left.find(*left.rbegin()));
            }
            right.erase(right.begin());
        }
    }

    bool remove(long item) {
        //cout<<"Calling Remove \n";
        if(isEmpty()) {
            return false;
        }
        else {

            if(left.count(item) > 0) {
                left.erase(left.find(item));

                if(left.size() < right.size()) {
                    left.insert(*right.begin());
                    right.erase(right.begin());
                }
                return true;
            }
            else if(right.count(item) > 0) {
                right.erase(right.find(item));

                if(left.size() > right.size() + 1) {
                    right.insert(*left.rbegin());
                    left.erase(left.begin());
                }
                return true;
            }
            else {
                return false;
            }
        }
    }

    void median() {
        // cout<<"Calling Median \n";

        /*        
        multiset<long>::iterator x;
        multiset<long>::iterator y;

        cout<<"size = "<<size()<<endl;
        cout<<"Left : \n";
        for (x=left.begin(); x!=left.end(); ++x)
        	cout << ' ' << *x;
        cout<<endl;
        cout<<"Right : \n";
        for (y=right.begin(); y!=right.end(); ++y)
        	cout << ' ' << *y;
        cout<<endl;
        */

        if(size() % 2 == 0) {
            multiset<long>::iterator itl = left.end();
            multiset<long>::iterator itr = right.begin();

            long l = *(--itl);
            long r = *itr;
            long s = l + r;

            if (l%2 == r%2) {
                printf("%.0lf\n",(l*1.+r)/2.);
            }
            else {
                printf("%.1lf\n",(l*1.+r)/2.);
            }


        }
        else {

            multiset<long>::iterator itl = left.end();
            long l = *(--itl);
            cout<<l<<endl;
        }
    }

};

int main() {

    long T;
    cin>>T;

    SortedElements *se;
    se = new SortedElements;

    while(T--) {
        char op;
        cin>>op;
        long item;
        cin>>item;

        if(op == 'a') {
            se->insert(item);
            se->median();
        }
        else if(op == 'r') {
            bool isRemoved = se->remove(item);
            if(se->size() == 0 || !isRemoved) {
                cout<<"Wrong!"<<endl;
            }
            else {
                se->median();
            }
        }
        //cout<<"Size: "<<se->size()<<endl;
    }

    return 0;
}
