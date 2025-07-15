package Searching_Sorting;

public class FindMinInRotatedSortedArr2 {
        public int findMin(int[] nums) {
            int start = 0;
            int end = nums.length - 1;
            while (start < end) {
                while (start < end && nums[start] == nums[start + 1]) {
                    start++;
                }
                while (start < end && nums[end] == nums[end - 1]) {
                    end--;
                }
                int mid = start + (end - start) / 2;
                if (nums[mid] > nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            return nums[end];
        }
    }
