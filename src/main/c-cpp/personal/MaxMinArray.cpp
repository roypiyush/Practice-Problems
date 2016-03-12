#include <iostream>

using namespace std;

void swap(int arr[], int s, int d) {

    int t = arr[s];
    arr[s] = arr[d];
    arr[d] = t;
}

int main() {

    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    bool setMax = true;
    int i = 0, size = 10, j = size - 1;

    for(; i < 10; i++) {

	if(setMax) {
	    swap(arr, i, j);
	    j--;
	    setMax = false;
	}
	else {

	    int min;
	    if(i < j) {
		// search min from j + 1
	        min = j + 1;
	    }
            else {
	        // search min from i + 1
	        min = i + 1;
            }

	    for(int k = j + 1; k < size; k++) {
		if(arr[min] > arr[k]) {
		    min = k;
		}
	    }
	    swap(arr, min, i);
	    setMax = true;
	}
    }

    for(i = 0; i < 10; i++) {
	cout<<arr[i]<<' '<<endl;
    }
    return 0;
}
