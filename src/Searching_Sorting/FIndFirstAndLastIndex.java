package Searching_Sorting;

public class FIndFirstAndLastIndex {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] ans = new int[2];
            ans[0] = search_start(nums, target);
            ans[1] = search_last(nums, target);
            return ans;
        }


        public int search_start(int[] arr, int target) {
            int index = -1;
            int start = 0;
            int end = arr.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] == target) {
                    end = mid - 1;
                    index = mid;
                } else if (arr[mid] > target) {
                    end = mid - 1;

                } else {
                    start = mid + 1;
                }
            }
            return index;
        }

        public int search_last(int[] arr, int target) {
            int index = -1;
            int start = 0;
            int end = arr.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] == target) {
                    start = mid + 1;
                    index = mid;
                } else if (arr[mid] > target) {
                    end = mid - 1;

                } else {
                    start = mid + 1;
                }
            }
            return index;
        }

    }

}
