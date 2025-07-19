package Searching_Sorting;

import java.util.Scanner;

public class MaximumSubarraySizeSumLessThanK {
    /*
    Maximum subarray size having all subarrays sums less than k
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        int k = input.nextInt();

        int ans = findMaxSubArraySize(arr, k);
        int ans2 = findMaxSubArrayUsingBinarySearch(arr,k);
        System.out.println(ans);
        System.out.println(ans2);
    }

    private static int findMaxSubArraySize(int[] arr, int k) {

        /*
        Brute Force Approach
        We are using 3 loops so time complexity is O(n^3) which is very bad
        outer loop is for every length (1,2,3,4) means for every length we will check that length
        subArrays , will do sum for every subArray of that particular length and calculate maxSum of
        that particular length
        middle loop : used to take care that inner loop does not go out of bound and till what index
        j has to go (n-i+1) .
        inner loop is for doing sum for covering particular length j-> starting index + i -> length

        Because a subArray of size i starts at index j, and needs i elements ahead of j.
        So the last valid j is:
        j + i - 1 < n  →  j < n - i + 1
        That means j goes from 0 to n - i inclusive.
        */
        /*

         The idea is to generate all possible subArrays of all sizes and find sum of their elements.
         To do so, use three nested loops, where the outermost loops mark the size of the subArray,
         the middle loop marks the starting index of the subArray, and the inner loops marks the last
         index of the subArray.
         For any integer x in range [1, n], if all the subArrays of array arr[] of size x, has sum of
         their elements less than or equals to k, store the value x in answer and move to x + 1.
         At last print the result.

         */


        int n = arr.length;
        int ans = -1;
        // outer loop is for checking every length subarrau
        for (int i = 1; i <= n; i++) {
            int maxSum = Integer.MIN_VALUE;

            //  middle loop
            for (int j = 0; j < n - i + 1; j++) {
                int sum = 0;
                // inner loop is for calculating sum
                for (int l = j; l < i + j; l++) {
                    sum += arr[l];
                }
                maxSum = Math.max(maxSum, sum);
            }
            if (maxSum <= k) {
                ans = Math.max(ans, i);
            }
        }
        return ans;
    }

    private static int findMaxSubArrayUsingBinarySearch(int[] arr, int k) {
        // Time Complexity : O(NlogN)
        int n = arr.length;
        int start = 1;
        int end = n;
        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValidSize(arr, mid, k)) {
                ans = mid;      // this size is valid, try for bigger
                start = mid + 1;
            } else {
                end = mid - 1;  // this is not valid reduce size and try again
            }
        }
        return ans;
    }

    private static boolean isValidSize(int[] arr, int size, int k) {
        /*
        Why Binary Search Works?
        The key property that allows binary search:
        If a subarray of size L is valid (i.e., all subarrays of size L have sum < k),
        then all smaller sizes are also valid.
        If size L is not valid, then all larger sizes will also be invalid.
         ️This is a monotonic property, which is perfect for binary search!

        ✅ Binary Search Strategy:
        We binary search on subarray size L from 1 to n.
        For each L, check if all subarrays of size L have sum < k.
        If yes, move to bigger size (low = mid + 1)
        If no, move to smaller size (high = mid - 1)

         ✅ How to Check Validity of Size L?
         We can use a sliding window of size L:
         Find sum of first window of size L.
         Slide the window forward by 1 each time.
         If any window has sum ≥ k, this size is invalid.
         */

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
        }
        if (sum > k) {
            return false;
        }

        //sliding window
        for (int i = size; i < arr.length; i++) {
            sum += arr[i] - arr[i - size];
            if (sum > k) {
                return false;
            }
        }
        return true;
    }
}
