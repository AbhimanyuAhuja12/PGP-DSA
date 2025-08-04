package ArraysAndStrings;

import java.util.Scanner;

public class sumOfAllSubmatricesOfMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rows = input.nextInt();
        int cols = input.nextInt();
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        int ans = findSumOfSubmatrices(matrix);
        System.out.println(ans);
    }
    /*
The idea is to calculate the contribution of each element to the total sum by determining in
how many different submatrices that element appears. We can directly compute how many submatrices
contain each element in O(1) time and use this to find each element's total contribution to the sum.

Step by step approach:

•For each element at position (i ,j), calculate how many different top-left corners could
form a submatrix containing it: (i+1)*(j+1).
•Calculate how many different bottom-right corners could form a submatrix containing it: (n-i)*(n-j).
•The total number of submatrices containing this element is the product: (i + 1)(j + 1)(n - i)*(n - j).
•Multiply this count by the element's value to get its total contribution to the sum.
*/

    private static int findSumOfSubmatrices(int[][] matrix) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                int topLeft = (i + 1) * (j + 1);
                int botomRight = (matrix.length - i) * (matrix[0].length - j);

                int totalSubmatricesCount = topLeft * botomRight;

                sum += totalSubmatricesCount * matrix[i][j];
            }
        }
        return sum;
    }

    private static int findSumOfSubmatricesBruteForce(int[][] matrix) {
        // time complexity = O(n^6)
        int sum = 0;
        int n = matrix.length;
        for (int startRow = 0; startRow < n; startRow++) {
            for (int startCol = 0; startCol < n; startCol++) {

                for (int endRow = 0; endRow < n; endRow++) {
                    for (int endCol = 0; endCol < n; endCol++) {


                        for (int i = startRow; i < endRow; i++) {
                            for (int j = startCol; j < endCol; j++) {
                                sum += matrix[i][j];
                            }
                        }
                    }
                }
            }
        }
        return sum;
    }


}
