#include <iostream>

using namespace std;


int binarySearch(vector<int> &A, int size, int key) {

    int low, high, mid;
    low = 0; high = size - 1;
    while(low <= high) {
	mid = (low + high) / 2;
	if(key == A[mid]) {
	    return mid;
	}
	else if( key > A[mid]) {
	    low = mid + 1;
	}
	else {
	    high = mid - 1;
	}
    }

}

int main() {

    vector<int> A;
    A.push_back(1);
    A.push_back(2);
    A.push_back(3);
    A.push_back(4);
    A.push_back(5);
    A.push_back(6);
    A.push_back(7);
    A.push_back(8);
    A.push_back(9);
    A.push_back(10);

        

    return 0;
}
