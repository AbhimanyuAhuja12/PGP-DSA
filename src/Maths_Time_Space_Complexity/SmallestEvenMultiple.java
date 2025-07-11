package Maths_Time_Space_Complexity;

public class SmallestEvenMultiple {
    public int smallestEvenMultiple(int n) {
        //time complexity is O(log logN)
        int ptr=1;
        for(int i=n;i<Integer.MAX_VALUE;i*=ptr){
            ptr++;
            if(i%2==0 && i%n==0){
                return i;
            }
        }
        return  -1;
    }

    public int smallestEvenMultiple2(int n) {
        return n%2==0 ? n : n*2;
    }
}
