package ArraysAndStrings;

import java.util.Stack;

public class MaxNestingDepthofParanthesis {
    class Solution {

        public int maxDepth(String s) {
            char[] arr = s.toCharArray();
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                count = Math.max(count, checkDepth(arr, i));
            }
            return count;
        }

        private static int checkDepth(char[] arr, int ptr) {
            int leftBrackets = 0;
            int rightBrackets = 0;
            for (int i = ptr - 1; i >= 0; i--) {
                if (arr[i] == '(') {
                    leftBrackets++;
                } else if (arr[i] == ')') {
                    rightBrackets++;
                }
            }
            return leftBrackets - rightBrackets;
        }
    }

    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int maxDepth = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
                maxDepth = Math.max(maxDepth, stack.size());
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        return maxDepth;
    }

    public int maxDepthBestApproach(String s) {
        int openBracket = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openBracket++;
                result = Math.max(result, openBracket);
            } else if (s.charAt(i) == ')') {
                openBracket--;
            }
        }
        return result;
    }

}
