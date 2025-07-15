package Maths_Time_Space_Complexity;

import java.util.HashSet;

public class HappyNumbers {
    public static void main(String[] args) {
        /*
        HashSet<Integer> set = new HashSet<>();

        set.add(5);
        set.add(4);
        boolean ans = set.contains(4);
        System.out.println(ans);
        */
    }

    class Solution1 {

        public boolean isHappy(int n) {
            HashSet<Integer> set = new HashSet<Integer>();
            while (n != 1) {
                if (set.contains(n)) {
                    return false;
                }
                set.add(n);
                n = getSquareSum(n);
            }
            return true;
        }

        private static int getSquareSum(int n) {
            int sum = 0;
            while (n > 0) {
                int last = n % 10;
                int sq = last * last;
                sum += sq;
                n /= 10;
            }
            return sum;
        }
    }

    class Solution {
        public boolean isHappy(int n) {
            int slow = n;
            int fast = n;

            do {
                slow = findSquare(slow);

                fast = findSquare(findSquare(fast));

            } while (slow != fast);

            if (slow == 1) return true;

            return false;
        }

        public int findSquare(int number) {
            int square = 0;
            while (number > 0) {
                int rem = number % 10;
                square += rem * rem;
                number /= 10;
            }
            return square;
        }
    }
    /*
    Time Complexity: O(logn) per iteration, but total is O(1) (bounded)
Let’s break this down:
🔹 getSquareSum(n)
Takes a number n and computes the sum of squares of its digits.

Number of digits in n = O(logn) (base 10).

So this function runs in O(logn) time.

🔹 Main loop:
The number is repeatedly replaced by the sum of the squares of its digits.

So you might think the total time is O(logn) * number of iterations.

But here's the critical optimization insight:

🔍 Bounded Iterations: Constant-time due to cycle behavior
For any positive integer n, the sequence of square-sum transformations eventually falls below 243.

Why? The maximum sum of squares of digits for any number is bounded:

9² = 81. Even for a number with hundreds of 9s, the result is manageable.

For example, 999 → 9² + 9² + 9² = 243.

So even if you start with a huge n, the sequence quickly shrinks into a small range.

After that, you're just checking for cycles in a fixed small set of integers (≤243).

✅ Therefore, the number of unique numbers processed is bounded.

✅ Final Time Complexity: O(1) amortized, due to:
Each iteration: O(log n) for digit processing

Total iterations: Bounded to ~20-30 values (constant for all practical n)

So: O(1) total for fixed range of inputs

✅ Space Complexity: O(1)
You're using a HashSet to track visited numbers.

Since the number of unique values generated in the sequence is bounded (due to cycles always happening under 243), the size of the set is also bounded.

🔹 Worst case:
At most ~20-30 different numbers before a cycle or 1 is reached.

✅ So space is also O(1) (constant), not dependent on the input size.

*/

}
