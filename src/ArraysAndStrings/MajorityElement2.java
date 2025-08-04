package ArraysAndStrings;
import java.util.*;
public class MajorityElement2 {
    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int count = map.getOrDefault(nums[i], 0) + 1;
                map.put(nums[i], count);
            }
            ArrayList<Integer> result = new ArrayList<>();
            int maxTimes = nums.length / 3;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > maxTimes) {
                    result.add(entry.getKey());
                }
            }
            return result;
        }
    }
}
