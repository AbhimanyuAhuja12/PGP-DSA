package ArraysAndStrings;

import java.util.Scanner;

public class CoinsOfGeekLand {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
        int K = input.nextInt();

        int ans = Maximum_Sum(matrix, N, K);
        System.out.println(ans);
    }

    public static int Maximum_Sum(int mat[][], int N, int K) {
        // Your code goes here
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i <= N-K; i++) {
            for (int j = 0; j <= N-K; j++) {
                int sum = 0;
                for (int row = i; row < i + K && row < N; row++) {
                    for (int ptr = j; ptr < j + K && ptr < N; ptr++) {
                        sum += mat[row][ptr];
                    }
                }
                maxSum = Math.max(sum, maxSum);
            }
        }

        return maxSum;
    }
}

