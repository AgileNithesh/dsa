package data.structures.algorithms.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.put(i,nums[i]);
        }

        for(int i = 0; i < nums.length; i++){
            int rem = target - nums[i];

            if(map.containsValue(rem)){
                result[0] = i;
                IO.println(i);
                for(Integer k: map.keySet()){
                    if (rem == map.get(k) && (k != i)){
                        result[1] = k;
                        return result;
                    }
                }
            }
        }

        return result;
    }

}
