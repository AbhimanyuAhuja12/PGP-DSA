package Searching_Sorting;

public class kthLargestElement {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return kthLargestElement(nums, k);
        }

        private static int kthLargestElement(int[] arr, int k) {
            int n = arr.length;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            // Find the min and max values in the array
            for (int num : arr) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }

            int start = min;
            int end = max;

            while (start <= end) {
                int mid = start + (end - start) / 2;

                int countGreater = 0;
                int countEqual = 0;

                for (int num : arr) {
                    if (num > mid) {
                        countGreater++;
                    } else if (num == mid) {
                        countEqual++;
                    }
                }

                // Check if mid is the k-th largest
                if (countGreater < k && countGreater + countEqual >= k) {
                    return mid;
                } else if (countGreater >= k) {
                    // Go right: mid is too small
                    start = mid + 1;
                } else {
                    // Go left: mid is too large
                    end = mid - 1;
                }
            }

            return -1; // should never reach here
        }
    }

}
