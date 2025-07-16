package Searching_Sorting.SortingAlgos;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
    what happens in Bubble Sort
      times : how many times we have to run the inside loop or one cycle (pass)
      time complexity : O(n^2) worst and avg both
      Stable : yes
      InPlace : yes
      online : no
     */

    private static void bubbleSort(int[] arr) {

        for (int pass = 0; pass < arr.length; pass++) {
            boolean didSwap = false;  // reset the boolean in every swap

            // Compare adjacent elements up to the unsorted portion
            for (int i = 0; i < arr.length - pass - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    //swap
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;

                    didSwap = true;
                }
            }
            if (!didSwap) break;  // exit early if swap is not done
        }
    }
}
