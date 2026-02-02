package data.structures.algorithms.leetcode.medium;

import java.lang.reflect.AnnotatedArrayType;
import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {

    /*
    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
    such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
    Notice that the solution set must not contain duplicate triplets.

    Example 1:

    Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]
    Explanation:
    nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
    nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
    nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
    The distinct triplets are [-1,0,1] and [-1,-1,2].
    Notice that the order of the output and the order of the triplets does not matter.
    */

    static void main() {
        IO.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplet = new ArrayList<>();

        // sort the given array
        Arrays.sort(nums);

        // 2 pointers approach
        // [-4,-1,-1,0,1,2]
        //   i  j        k

        // keep i fixed and move j,k based on the required 3rd number
        // when the triplet is found move i,j,k to a different values than the current ones


        for(int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i-1] == nums[i]) continue;
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    triplet.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j-1] == nums[j]) j++;
                    while (j < k && nums[k-1] == nums[k]) k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return triplet;
    }

    // 0(n2) solution

    /*
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> triplet = new HashSet<>();

        Set<Integer> lookup_set = new HashSet<>();

        for(int i = 0; i < nums.length - 1; i++){
            lookup_set.clear();
            for(int j = i +1; j < nums.length; j++){
                int third = - (nums[i] + nums[j]);
                // check if the element is in set
                if(lookup_set.contains(third)){
                    List<Integer> temp = Arrays.asList(nums[i],nums[j],third);
                    Collections.sort(temp);
                    triplet.add(temp);
                }
                //keep adding current element
                lookup_set.add(nums[j]);

            }
        }


        return triplet.stream().toList();
    }
    */



    // below is my brute force solution

    /*public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> triplet = new HashSet<>();



        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {

                int third = -nums[i] - nums[j];

                    for (int k = j + 1; k < nums.length; k++) {
                        if (third == nums[k] && i!=k && k != j) {
                            List<Integer> tripletChild = new ArrayList<>();
                            tripletChild.add(nums[i]);
                            tripletChild.add(nums[j]);
                            tripletChild.add(nums[k]);
                            Collections.sort(tripletChild);
                            triplet.add(tripletChild);
                        }
                    }

            }
        }

        return triplet.stream().collect(Collectors.toList());
    }*/
}
