package Searching_Sorting.SortingAlgos;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 12, 1, 34, 23, 0, 44, 2, 7};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /*
     Inplace - yes
     Online - yes  // if you add new elements while algorithm is running it will correct answer
     Stable - yes
     Space Complexity - O(1)
     Time Complexity - O(n^2) for worst and avg case ,  O(n) for best case
     */

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // Shift elements of arr[0..i-1], that are greater than key, to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert the key at its correct position
            arr[j + 1] = key;
        }
    }
}
