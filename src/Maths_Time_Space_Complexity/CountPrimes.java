package Maths_Time_Space_Complexity;

public class CountPrimes {
    class Solution {
        public int countPrimesBasic(int n) {
            if (n <= 1) return 0;
            int count = 0;
            for (int i = 2; i < n; i++) {
                if (isPrime(i)) {
                    count++;
                }
            }
            return count;
        }

        private static boolean isPrime(int num) {
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }

        static boolean[] sieve = new boolean[5000001];
        static int N = 5000000;
        static boolean isSieveBuilt = false;

        public static void createSieve() {
            if (isSieveBuilt)
                return;
            isSieveBuilt = true;

            for (int i = 2; i <= N; i++) {
                sieve[i] = true;
            }
            for (int i = 2; i * i <= N; i++) {
                if (sieve[i] == true) {
                    for (int j = i * i; j <= N; j += i) {
                        sieve[j] = false;
                    }
                }
            }
        }

        public int countPrimes(int n) {
            createSieve();
            int count = 0;
            for (int i = 2; i < n; i++) {
                if (sieve[i] == true) {
                    count++;
                }
            }
            return count;
        }
    }
}
