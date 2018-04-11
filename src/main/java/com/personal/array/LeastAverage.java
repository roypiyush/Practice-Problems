/**
 *
 */
package com.personal.array;

/**
 * @author piyush
 */
public class LeastAverage {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int arr[] = {3, 7, 90, 20, 10, 50, 40};
        int k = 3;

        double leastAvg = 0;
        int curSum = 0;

        int startIndex = 0, endIndex = k - 1;
        int lStartIndex = 0, lEndIndex = k - 1;

        for (int i = startIndex; i <= endIndex; i++) {
            curSum += arr[i];
        }
        leastAvg = curSum / k;

        for (int i = k; i < arr.length; i++) {
            curSum = curSum - arr[startIndex++] + arr[i];

            double avg = curSum / k;
            if (avg < leastAvg) {
                lStartIndex = startIndex;
                lEndIndex = i;
                leastAvg = avg;
            }
        }

        System.out.printf("Least avg is from %d to %d. Avg = %f", lStartIndex, lEndIndex, leastAvg);

    }

}
