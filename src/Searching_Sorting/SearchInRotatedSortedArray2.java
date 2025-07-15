package Searching_Sorting;

public class SearchInRotatedSortedArray2 {


             public boolean search2ndMethod(int[] nums, int target) {
                 int start = 0;
                 int end = nums.length - 1;
                 while (start <= end) {
                     int mid = start + (end - start) / 2;
                     if (nums[mid] == target) {
                         return true;
                     } else if (nums[start] < nums[mid]) {
                         // Left Half is Sorted

                         // now we will check target is present in this half or not
                         if (nums[start] <= target && nums[mid] >= target) {
                             end = mid - 1;
                         } else {
                             start = mid + 1;
                         }
                     } else if (nums[start] == nums[mid]) {
                         start++; // skip duplicate
                     } else {
                         // RIght Half is Sorted

                         if (nums[mid] <= target && nums[end] >= target) {
                             start = mid + 1;
                         } else {
                             end = mid - 1;
                         }
                     }
                 }
                 return false;
             }

        public boolean search(int[] nums, int target) {
            int n = nums.length;
            int pivot = findPivot(nums);
            if (target >= nums[pivot] && target <= nums[n - 1]) {
                return binarySearch(nums, pivot, n - 1, target);
            } else {
                return binarySearch(nums, 0, pivot - 1, target);
            }
        }

        private static boolean binarySearch(int[] nums, int start, int end, int target) {
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] == target) {
                    return true;
                } else if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return false;
        }

        private static int findPivot(int[] nums) {
            int start = 0;
            int end = nums.length - 1;
            while (start < end) {

                // we have to skip duplicate elements
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
            return start;
        }
    }

