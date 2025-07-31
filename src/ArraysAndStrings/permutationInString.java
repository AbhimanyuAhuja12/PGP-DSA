package ArraysAndStrings;
import java.util .*;
public class permutationInString {

        public boolean checkInclusion(String s1, String s2) {
            Set<String> allPermutations = new HashSet<>(); // Use Set to avoid duplicate permutations
            generatePermutations(s1, "", new boolean[s1.length()], allPermutations);

            for (String perm : allPermutations) {
                if (isPresent(perm, s2)) {
                    return true;
                }
            }
            return false;
        }

        // Checks if s2 contains the permutation string
        private static boolean isPresent(String perm, String s2) {
            return s2.contains(perm);
        }

        // Generates all unique permutations using backtracking
        private static void generatePermutations(String str, String curr, boolean[] used, Set<String> result) {
            if (curr.length() == str.length()) {
                result.add(curr);
                return;
            }

            for (int i = 0; i < str.length(); i++) {
                if (used[i]) continue;

                used[i] = true;
                generatePermutations(str, curr + str.charAt(i), used, result);
                used[i] = false;
            }
        }
    }

