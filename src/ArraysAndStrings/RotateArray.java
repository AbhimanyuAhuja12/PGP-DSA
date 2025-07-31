package ArraysAndStrings;

public class RotateArray {
    class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length;

            if (k == 0 || n <= 1) {
                return;
            }

            k = k % n;

            reverse(nums, 0, n - k - 1);
            reverse(nums, n - k, n - 1);
            reverse(nums, 0, n - 1);

        }

        private static void reverse(int[] arr, int start, int end) {
            while (start < end) {
                // swap
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle cases where k > n
        if (k == 0 || n <= 1)
            return; // No rotation needed

        int count = 0; // Tracks the number of elements moved
        for (int start = 0; count < n; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n; // Calculate the next index
                int temp = nums[next]; // Store the value at the next index
                nums[next] = prev; // Move the current element to its new position
                prev = temp; // Update the value to move next
                current = next; // Move to the next index
                count++; // Increment the count of moved elements
            } while (start != current); // Stop when the cycle completes
        }
    }
}
