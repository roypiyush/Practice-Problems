#include <iostream>
#include <algorithm>
using namespace std;

#define max(a, b) a >= b ? a : b;

int main()
{
    
    int T; cin>>T;
    
	while(T-- > 0) {
		int numberOfGuests;cin>>numberOfGuests;
		
		int arrivalTime[numberOfGuests];
		int departureTime[numberOfGuests];
				
		for(int i = 0; i < numberOfGuests; i++) {
			cin>>arrivalTime[i];
		}
		for(int i = 0; i < numberOfGuests; i++) {
			int duration;
			cin>>duration;
			departureTime[i] = arrivalTime[i] + duration;
		}
		
		sort(arrivalTime, arrivalTime + numberOfGuests);
		sort(departureTime, departureTime + numberOfGuests);
		
		int i = 0, j = 0, count = 0;
		int result = 0;
		while (i < numberOfGuests) {
			if(i == 0 && arrivalTime[i] > 0) {
				count++;i++;
			}
			else if(arrivalTime[i] < departureTime[j]) {
				i++;
				count++;
			}
			else if(departureTime[j] <= arrivalTime[i]) {
				count--;j++;
			}
			result = max(count, result);
		}
		cout<<result<<endl;
			
	}
    return 0;
}
