package ArraysAndStrings;

import java.util.Arrays;

public class MissingInArray {
    public static void main(String[] args) {
        int[] arr = {12, 3, 4, 5, 6, 7, 8, 1, 2, 9, 11};
        int missingNumber = missingNum4thApproach(arr);
        System.out.println(missingNumber);
    }

    private static int missingNum(int arr[]) {
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (arr[i] == i + 1) {
                continue;
            }
            return i + 1;
        }
        return n + 1;
    }

    private static int missingNum2ndApproach(int arr[]) {
        // code here
        int n = arr.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        long totalSum = ((n + 1) * (n + 2) / 2);

        return (int) (totalSum - sum);
    }

    private static int missingNum3rdApproach(int arr[]) {
        int n = arr.length;
        int XORelements = 0;
        int XORtotal = 0;

        for (int i = 0; i < n; i++) {
            XORelements ^= arr[i];   // XOR of all elements in the array
            XORtotal ^= (i + 1);     // XOR of numbers from 1 to n
        }

        XORtotal ^= (n + 1);         // Add XOR of last number (n+1)

        return XORelements ^ XORtotal; // Final XOR gives the missing number
    }

    private static int missingNum4thApproach(int arr[]) {
        int n = arr.length;
        int i = 0;
        while (i < n) {
            int correctIdx = arr[i] - 1;

            if (arr[i] >= 1 && arr[i] <= n && arr[i] != arr[correctIdx]) {
                //swap
                int temp = arr[i];
                arr[i] = arr[correctIdx];
                arr[correctIdx] = temp;
            } else {
                i++;
            }
        }
        for (int j = 0; j < n; j++) {
            if (arr[j] != j + 1) {
                return j + 1;
            }
        }
        return n + 1;
    }
}
