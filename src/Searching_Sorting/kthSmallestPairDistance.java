package Searching_Sorting;

import java.util.*;

public class kthSmallestPairDistance {
    class Solution {

        //MLE
        // public int smallestDistancePair(int[] nums, int k) {
        //     ArrayList<Integer> list = new ArrayList<>();
        //     for (int i = 0; i < nums.length - 1; i++) {
        //         for (int j = i + 1; j < nums.length; j++) {
        //             list.add(Math.abs(nums[j] - nums[i]));
        //         }
        //     }
        //     list.sort(null);
        //     return list.get(k - 1);
        // }

        public int smallestDistancePair(int[] nums, int k) {
            int n = nums.length;
            Arrays.sort(nums);
            int high = nums[n - 1] - nums[0];
            int low = Integer.MAX_VALUE;
            for (int i = 1; i < n; i++) {
                if (nums[i] - nums[i - 1] < low) {
                    low = nums[i] - nums[i - 1];
                }
            }

            while (low < high) {
                int mid = low + (high - low) / 2;
                int currAns = findPairsLessThanMid(mid, nums);
                if (currAns < k) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }

        private static int findPairsLessThanMid(int diff, int[] arr) {
            // we will do this by sliding window approach which is a 2 pointer approach
            int j = 0;
            int count = 0;
            for (int i = 1; i < arr.length; i++) {
                while (arr[i] - arr[j] > diff) {
                    j++;
                }
                count += i - j;
            }
            return count;
        }
    }

}
