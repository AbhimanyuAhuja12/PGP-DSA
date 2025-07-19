package Searching_Sorting.SortingAlgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {

    /**
     * Sorts an array of float numbers using the Bucket Sort algorithm.
     * Assumes that the input values are uniformly distributed in the range [0, 1].
     *
     * @param arr The input float array to be sorted.
     */
    private static void bucketSortAlgo(float[] arr) {
        int n = arr.length;
        if (n <= 0) return;

        // Step 1: Create n empty buckets (as ArrayLists)
        @SuppressWarnings("unchecked")
        ArrayList<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Step 2: Distribute array elements into appropriate buckets
        // Bucket index formula: (value * n), since values are in range [0, 1)
        for (float value : arr) {
            int bucketIndex = (int) (value * n);

            // Handle edge case: if value == 1.0, place it in the last bucket
            if (bucketIndex >= n) {
                bucketIndex = n - 1;
            }

            buckets[bucketIndex].add(value);
        }

        // Step 3: Sort individual buckets using a sorting algorithm of your choice
        for (ArrayList<Float> bucket : buckets) {
            Collections.sort(bucket);  // Using Java’s built-in TimSort (efficient for small lists)
        }

        // Step 4: Concatenate all sorted buckets into original array
        int index = 0;
        for (ArrayList<Float> bucket : buckets) {
            for (float value : bucket) {
                arr[index++] = value;
            }
        }
    }

    public static void main(String[] args) {
        float[] arr = {0.23f, 0.25f, 0.32f, 0.42f, 0.51f, 0.52f, 0.68f, 0.75f, 0.92f, 1.0f};

        // Print original array
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(arr));

        // Perform Bucket Sort
        bucketSortAlgo(arr);

        // Print sorted array
        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(arr));
    }

    private static void bucketSortAlgoMoreGeneralized(float[] arr) {
        int n = arr.length;
        if (n <= 0) return;

        // Step 1: Find the min and max in the array
        float min = Float.MAX_VALUE;
        float max = Float.MIN_VALUE;

        for (float val : arr) {
            if (val < min) min = val;
            if (val > max) max = val;
        }

        // Step 2: Create buckets
        @SuppressWarnings("unchecked")
        ArrayList<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Step 3: Normalize and distribute values into buckets
        for (float val : arr) {
            int bucketIndex = (int) (((val - min) / (max - min)) * (n - 1));
            buckets[bucketIndex].add(val);
        }

        // Step 4: Sort each bucket
        for (ArrayList<Float> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Step 5: Concatenate all buckets into original array
        int index = 0;
        for (ArrayList<Float> bucket : buckets) {
            for (float val : bucket) {
                arr[index++] = val;
            }
        }
    }

}
