package Maths_Time_Space_Complexity;

import java.util.ArrayList;
import java.util.Scanner;

/*
Why N = 86028121?
The 5,000,000th prime number is 86,028,121.

To support queries like "Print the k-th prime number for any k ≤ 5e6", we must precompute all primes up to 86 million+.

So, we set N = 86028121 — slightly above the 5,000,000th prime — ensuring correctness and safety.

This assumption ensures we can preprocess and answer each query in O(1) using an indexed list of primes.
 */

public class kthPrimeNumber {

    static int N =86028121;
    static boolean[] sieve = new boolean[N+1];

    static ArrayList<Integer> list = new ArrayList();

    private static void createSieve(){
        for(int i=2;i<=N;i++){
            sieve[i]=true;
        }
        /*
        instead of above loop we can also write something like this
        Arrays.fill(isPrime, 2, N + 1, true);
         */

        for(int i=2;i*i<=N;i++){
            if(sieve[i]==true){
                for(int j=i*i;j<=N;j+=i){
                    sieve[j]=false;
                }
            }
        }

        for(int i=2;i<=N;i++){
            if(sieve[i]==true){
                list.add(i);
            }
        }
    }
    public static void main(String[] args) {
         createSieve();
         Scanner input = new Scanner(System.in);
         int q = input.nextInt();
         while(q-->0){
             int k = input.nextInt();
             System.out.println(list.get(k-1));
         }
    }
}
