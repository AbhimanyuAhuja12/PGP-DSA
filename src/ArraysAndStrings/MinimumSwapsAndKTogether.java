package ArraysAndStrings;

public class MinimumSwapsAndKTogether {


    class Solution {
        // Function for finding maximum and value pair
        int minSwap(int[] arr, int k) {
            int windowSize = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] <= k) {
                    windowSize++;
                }
            }
            int left = 0;
            int right = windowSize - 1;
            int ans = Integer.MAX_VALUE;
            while (right < arr.length) {
                int count = 0;
                for (int i = left; i <= right; i++) {
                    if (arr[i] > k) {
                        count++;
                    }
                }
                left++;
                right++;
                ans = Math.min(ans, count);

            }
            return ans;
        }

        int minSwapOptimized(int[] arr, int k) {
            int n = arr.length;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] <= k) count++;
            }
            int bad = 0;
            for (int i = 0; i < count; i++) {
                if (arr[i] > k) bad++;
            }
            int ans = bad;
            for (int i = 0, j = count; j < n; j++, i++) {
                if (arr[i] > k) bad--;
                if (arr[j] > k) bad++;

                ans = Math.min(bad, ans);
            }
            return ans;
        }
    }

}
