package Maths_Time_Space_Complexity;

public class addDigits {
    public static void main(String[] args) {
        System.out.println(addDigits(284928492));
    }

    //     Time Complexity for this is O(logn)
    public static int addDigits(int num) {
        // early return for single digit number
        if (num < 10) return num;

        while (num >= 10) {
            int sum = 0;

            //add digits one by one
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            num = sum; // update num with sum of its digits
        }

        return num;
    }
    private static int addDigits2ndApproach(int n){
        //Time complexity is O(1)
        // remember divisibility rule of 9
        // digital root approach
        if(n==0) return 0;
        else if(n%9==0) return 9;
        return n%9;
    }
}