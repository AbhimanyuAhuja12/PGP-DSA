package Searching_Sorting;

public class kthSmallestElement {
    /*
    Kth Smallest element in the array using constant space when array can't be modified

    One way is we can simply sort it and return arr[k-1]

    Time complexity : O(n⋅log(max−min))
    */
    public static void main(String[] args) {
        int[] arr = {45, 2, 34, 12, 5, 0, 67};
        int ans = kthSmallestElement(arr, 3);
        System.out.println(ans);

    }

    private static int kthSmallestElement(int[] arr, int k) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }
        int start = min;
        int end = max;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            int countLess = 0;
            int countEqual = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] < mid) {
                    countLess++;
                } else if (arr[i] == mid) {
                    countEqual++;
                }
            }

            if (countLess < k && (countEqual + countLess < k)) {
                start = mid + 1;
            } else if (countLess >= k) {
                end = mid - 1;
            } else {
                /*
                if (countLess < k && countLess + countEqual >= k)
                The k-th smallest lies between countLess + 1 to countLess + countEqual
                So mid must be the k-th smallest.
                 */
                return mid;
            }
        }
        return -1;
    }

}
