package Searching_Sorting;

import java.util.HashMap;

public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = map.containsKey(nums[i]) ? map.get(nums[i]) : 0;
            map.put(nums[i], count + 1);
        }
        for (int ptr = 0; ptr < nums.length; ptr++) {
            if (map.get(nums[ptr]) == 1) {
                return nums[ptr];
            }
        }
        return -1;
    }

    public int singleNonDuplicate2(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            while (start + 1 <= end && nums[start] == nums[start + 1]) {
                start += 2;
            }
            while (end - 1 >= start && nums[end] == nums[end - 1]) {
                end -= 2;
            }
        }
        return nums[start];
    }

    public int singleNonDuplicateBest(int[] nums) {
        if (nums.length == 1) return nums[0];
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid == 0 && nums[0] != nums[1]) {
                return nums[mid];
            } else if (mid == nums.length - 1 && nums[nums.length - 1] != nums[nums.length - 2]) {
                return nums[mid];
            } else if (nums[mid - 1] != nums[mid] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            } else if (mid % 2 == 0) {
                // mid is at even position means left and right both are even length
                if (nums[mid] == nums[mid - 1]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}

