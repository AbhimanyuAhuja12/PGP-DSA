package Searching_Sorting.SortingAlgos;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {45, 23, 12, 67, 2, 1, 8, 32, 6};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
   /*
       Time complexity : O(n^2) for best , worst and avg
       inplace yes as it does not use extra space
       stable  No   (unless Modified)
       Online No

    */
    private static void selectionSort(int[] arr) {
        int endIndex = arr.length - 1;
        while (endIndex >= 0) {
            int maxIdx = 0;
            for (int i = 0; i <= endIndex; i++) {
                if (arr[i] > arr[maxIdx]) {
                    maxIdx = i;
                }
            }
            // swap of last element with max element
            int temp = arr[endIndex];
            arr[endIndex] = arr[maxIdx];
            arr[maxIdx] = temp;
            endIndex--;
        }
    }
}
