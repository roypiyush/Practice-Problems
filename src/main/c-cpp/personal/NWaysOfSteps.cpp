#include <iostream>

using namespace std;


int number_of_ways(int N, int k) {

	if(N < 0)
		return 0;
	if(N == 0)
		return 1;
	
	int result = 0;
	for(int i = 1; i <= k; i++) {
		if(N - i < 0) break;
		int l = number_of_ways(N - i, k);
		result += l;
	}

	return result;
}


int main() {

	int N = 4;
	int k = 4;

	cout<<number_of_ways(N, k)<<endl;
	return 0;
}