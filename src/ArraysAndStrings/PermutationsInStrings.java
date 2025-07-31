package ArraysAndStrings;

public class PermutationsInStrings {
    class Solution {
        // public boolean checkInclusion(String s1, String s2) {
        //     Set<String> allPermutations = new HashSet<>(); // Use Set to avoid duplicate permutations
        //     generatePermutations(s1, "", new boolean[s1.length()], allPermutations);

        //     for (String perm : allPermutations) {
        //         if (isPresent(perm,s2)) {
        //             return true;
        //         }
        //     }
        //     return false;
        // }

        // // Checks if s2 contains the permutation string
        // private static boolean isPresent(String perm, String s2) {
        //     return s2.contains(perm);
        // }

        // // Generates all unique permutations using backtracking
        // private static void generatePermutations(String str, String curr, boolean[] used, Set<String> result) {
        // if(curr.length()==str.length())
        // {
        //     result.add(curr);
        //     return;
        // }

        // for(
        // int i = 0;i<str.length();i++)
        // {
        //     if (used[i])
        //         continue;

        //     used[i] = true;
        //     generatePermutations(str, curr + str.charAt(i), used, result);
        //     used[i] = false;
        // }
        // }

        public boolean checkInclusion(String s1, String s2) {
            int[] freq = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                freq[s1.charAt(i) - 'a']++;
            }

            int windowSize = s1.length();

            for (int i = 0; i < s2.length(); i++) {
                int windowIdx = 0, idx = i;
                int[] windowFreq = new int[26];
                while (windowIdx < windowSize && idx < s2.length()) {
                    windowFreq[s2.charAt(idx) - 'a']++;
                    windowIdx++;
                    idx++;
                }

                if (isFreqSame(freq, windowFreq)) return true;
            }
            return false;
        }

        private static boolean isFreqSame(int[] freq1, int[] freq2) {
            for (int i = 0; i < 26; i++) {
                if (freq1[i] != freq2[i]) return false;
            }
            return true;
        }

    }

}
