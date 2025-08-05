package SLidingWindowAnd2Pointers;

import java.util.HashSet;
import java.util.Objects;

public class CountDistinctPairsWithDiffK {
    public int TotalPairs(int[] nums, int k) {
        HashSet<Pair> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    int a = Math.min(nums[i], nums[j]);
                    int b = Math.max(nums[i], nums[j]);
                    set.add(new Pair(a, b)); // always store smaller first
                }
            }
        }

        return set.size();
    }

    class Pair {
        int left;
        int right;

        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return left == pair.left && right == pair.right;
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, right);
        }
    }
}

