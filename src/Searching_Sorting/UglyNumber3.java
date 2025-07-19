package Searching_Sorting;

public class UglyNumber3 {
    class Solution {

        public int nthUglyNumber(int n, int a, int b, int c) {
            long low = 1;
            long high = (long) 2 * (int) 1e9;  // Safe upper bound

            while (low < high) {
                long mid = low + (high - low) / 2;
                long count = countUglyNumbersUpTo(mid, a, b, c);

                if (count >= n) {
                    high = mid; // Try to find smaller candidate
                } else {
                    low = mid + 1;
                }
            }

            return (int) low;
        }

        /**
         * Counts the number of integers <= limit that are divisible by a, b, or c
         * using the inclusion-exclusion principle.
         */
        private long countUglyNumbersUpTo(long limit, long a, long b, long c) {
            long ab = lcm(a, b);
            long bc = lcm(b, c);
            long ac = lcm(a, c);
            long abc = lcm(a, bc);

            return limit / a + limit / b + limit / c
                    - limit / ab - limit / bc - limit / ac
                    + limit / abc;
        }

        /**
         * Calculates the Least Common Multiple (LCM) of two numbers.
         */
        private long lcm(long x, long y) {
            return (x / gcd(x, y)) * y;  // Divide first to prevent overflow
        }

        /**
         * Calculates the Greatest Common Divisor (GCD) using Euclidean algorithm.
         */
        private long gcd(long x, long y) {
            while (y != 0) {
                long temp = y;
                y = x % y;
                x = temp;
            }
            return x;
        }
    }

}
