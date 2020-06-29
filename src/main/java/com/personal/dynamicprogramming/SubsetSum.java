package com.personal.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class SubsetSum {

    private int findSubsetInternal(int[] arr, int total, int i) {
        if (total == 0) {
            return 1;
        }
        if (total < 0 || i < 0) {
            return 0;
        }
        if (total < arr[i]) {
            return findSubsetInternal(arr, total, i - 1);
        }
        return findSubsetInternal(arr, total - arr[i], i - 1) + findSubsetInternal(arr, total, i - 1);
    }

    private int findSubset(int[] arr, int total) {
        return findSubsetInternal(arr, total, arr.length - 1);
    }

    private int findSubsetMemoized(int[] arr, int total) {
        Map<String, Integer> map = new HashMap<>();
        return findSubsetInternalMemoized(arr, total, arr.length - 1, map);
    }

    private int findSubsetInternalMemoized(int[] arr, int total, int i, Map<String, Integer> map) {
        String key = String.format("%s:%s", total, i);
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (total == 0) {
            return 1;
        }
        if (total < 0 || i < 0) {
            return 0;
        }
        if (total < arr[i]) {
            int result = findSubsetInternalMemoized(arr, total, i - 1, map);
            map.put(key, result);
            return  result;
        }
        int result = findSubsetInternalMemoized(arr, total - arr[i], i - 1, map) + findSubsetInternalMemoized(arr, total, i - 1, map);
        map.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        int sum = 6;
        int[] arr = new int[] {1, 2, 3, 4};
        SubsetSum subsetSum = new SubsetSum();
        System.out.println(subsetSum.findSubset(arr, sum));
        System.out.println(subsetSum.findSubsetMemoized(arr, sum));
    }

}
