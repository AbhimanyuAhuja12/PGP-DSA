package Searching_Sorting;
import java.util.*;

public class SortCharByFreq {
    class Solution {

        public String frequencySort(String s) {
            HashMap<Character, Integer> freqMap = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
            }

            ArrayList<Character> list = new ArrayList<>();
            for (char ch : s.toCharArray()) {
                list.add(ch);
            }

            Collections.sort(
                    list,
                    new Comparator<Character>() {

                        public int compare(Character a, Character b) {
                            int freqA = freqMap.get(a);
                            int freqB = freqMap.get(b);
                            if (freqA != freqB) {
                                return freqB - freqA;
                            } else {
                                return a - b;
                            }
                        }
                    }
            );
            String ans = "";
            for (char c : list) {
                ans = ans + c;
            }
            return ans;
        }
    }
    /*
    We can also use another optimized approach like bucket sort which is like a custom sort for us
     */

}
