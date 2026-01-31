package data.structures.algorithms.jpmorgan;

import java.util.*;


public class GroupAnagrams {


    static void main() {

    }


    /*Given an array of strings strs, group the anagrams together. You can return the answer in any order.

    Example 1:

    Input: strs = ["eat","tea","tan","ate","nat","bat"]

    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    Explanation:

    There is no string in strs that can be rearranged to form "bat".
    The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
    The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.*/

    public static List<List<String>> groupAnagrams(String[] strs){

        Map<String, List<String>> anagramMap = new HashMap<>();

        for(String s: strs){

            // convert each String to char array
            char[] c = s.toCharArray();
            // sort the char array -- rearranges in alphabetical order,
            // so if the key exists in map value gets appended
            Arrays.sort(c);
            String key = new String(c);
            anagramMap.computeIfAbsent(key, value -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>((anagramMap.values()));
    }



    // below is brute force approach which I wrote

    /*public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> annagramList = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {

            if (strs[i] != null) {
                List<String> childList = new ArrayList<>();
                childList.add(strs[i]);

                for (int j = i + 1; j < strs.length ; j++) {

                    if ((strs[j] != null) && isAnagram(strs[i], strs[j])) {
                        childList.add(strs[j]);
                        strs[j] = null;
                    }
                }
                annagramList.add(childList);
            }

        }

        return annagramList;
    }

    public boolean isAnagram(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        if (str1.length() == 0){
            return true;
        }

        Map<Character, Integer> str1_freq = new HashMap<>();
        Map<Character, Integer> str2_freq = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            if(str1_freq.get(str1.charAt(i)) != null){
                int count = str1_freq.get(str1.charAt(i)) + 1;
                str1_freq.put(str1.charAt(i), count);
            } else {
                str1_freq.put(str1.charAt(i), 1);
            }

            if(str2_freq.get(str2.charAt(i)) != null){
                int count = str2_freq.get(str2.charAt(i)) + 1;
                str2_freq.put(str2.charAt(i), count);
            } else {
                str2_freq.put(str2.charAt(i), 1);
            }
        }

        return str1_freq.equals(str2_freq);
    }*/
}
