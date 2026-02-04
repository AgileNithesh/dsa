package data.structures.algorithms.hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {


    static void main() {
        IO.println(containsDuplicate(new int[]{1,4,5,7,8,4,3,2}));
    }


    public static boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for(int num:nums){
            if(!set.add(num)){
                return true;
            }
        }

        return false;
    }

}
