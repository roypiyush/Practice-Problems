#include <iostream>

using namespace std;

struct SUB_ARRAY
{
	int maxLeft;
	int maxRight;
	int maxSum;
};


SUB_ARRAY findMaxCrossingSubArray(int A[], int low, int mid, int high)
{
	bool unassigned = true;
	int leftSum,rightSum;
	int sum = 0;
	int maxLeft,maxRight;
	
	// Find Max Left index
	for(int i = mid; i >= low; i--)
	{
		sum = sum + A[i];
		if(unassigned || leftSum < sum)
		{
			unassigned = false;
			leftSum = sum;
			maxLeft = i;
		}
	}

	//Reset 
	unassigned = true;
	sum = 0;

	// Find Max Right index
        for(int i = mid + 1; i <= high; i++)
        {       
                sum = sum + A[i];
                if(unassigned || rightSum < sum)
                {
                        unassigned = false;
                        rightSum = sum;
                        maxRight = i;
                }
        }

	SUB_ARRAY subArray = {maxLeft,maxRight,leftSum + rightSum};
	return subArray;

}

SUB_ARRAY findMaxSubArray(int A[], int low, int high)
{
	if(low == high)
	{
		SUB_ARRAY retSubArr = {low, high, A[low]};
		return retSubArr;
	}
	
	int mid = (low + high)/2;

	// Left Side Array
	SUB_ARRAY retLeftArr = findMaxSubArray(A, low, mid);

	SUB_ARRAY retRightArr = findMaxSubArray(A, mid + 1, high);

	SUB_ARRAY retCrossingArr = findMaxCrossingSubArray(A, low, mid, high);

	if(retLeftArr.maxSum >= retRightArr.maxSum && retLeftArr.maxSum >= retCrossingArr.maxSum)
		return retLeftArr;

	if(retRightArr.maxSum >= retLeftArr.maxSum && retRightArr.maxSum >= retCrossingArr.maxSum)
                return retRightArr;

	if(retCrossingArr.maxSum >= retRightArr.maxSum && retCrossingArr.maxSum >= retLeftArr.maxSum)
                return retCrossingArr;

	
}

int main(int argc, char* argv[])
{
	int A[] = {13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
	//int A[] = {-13,-3,-25,-20,-3,-16,-23,-18,-20,-7,-12,-5,-22,-15,-4,-7};

	//int A[]={};	

	int lengthOfArray = sizeof(A)/sizeof(int);

	if(lengthOfArray == 0)
	{
		cout<<"Maximum Sub Array cannot be calculated on Array of Zero Length.\n";
		return 0;
	}
	int low = 0;
	int high = lengthOfArray - 1;
	int mid = (low + high) / 2;
	SUB_ARRAY sa = findMaxCrossingSubArray(A,low,mid,high);

	cout<<"Maximum Sub Array[maxLeftIndex="<<sa.maxLeft<<", maxRightIndex="<<sa.maxRight<<", maxSum="<<sa.maxSum<<"]"<<endl;
	return 0;
}
