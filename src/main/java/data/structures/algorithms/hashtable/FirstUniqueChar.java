package data.structures.algorithms.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FirstUniqueChar {

    /**
     * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
     *
     * Example 1:
     *
     * Input: s = "leetcode"
     * Output: 0
     *
     * Explanation:
     * The character 'l' at index 0 is the first character that does not occur at any other index.
     */


    static void main() {
        IO.println(firstUniqChar("leetcodeplractice"));
    }

    public static int firstUniqChar(String s) {

        int index = -1;

        // 26 alphabets initialized with 0's
        int[] frequency = new int[26];

        for(int i=0; i<s.length(); i++){
            frequency[s.charAt(i) - 'a'] ++;
        }

        for(int i=0; i<s.length(); i++){
            if(frequency[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }

        return index;

    }

    // below solution is not efficient

    /*public static int firstUniqChar(String s) {

        int index = -1;
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for(char c: arr){

            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);

        }

        for(int i =0; i<arr.length; i++){
            if(map.get(arr[i]) == 1){
                return i;
            }
        }

        return index;

    }*/

}
