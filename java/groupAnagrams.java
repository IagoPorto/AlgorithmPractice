/**
Given an array of strings strs, group the
anagrams
together. You can return the answer in any order.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

    There is no string in strs that can be rearranged to form "bat".
    The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
    The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]

 

Constraints:

    1 <= strs.length <= 104
    0 <= strs[i].length <= 100
    strs[i] consists of lowercase English letters.


**/


import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int index = 0;

        for (String str : strs) {
            // Convert the string to a character array, sort it, and then convert it back to a string
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            // Check if the sorted string is already in the map
            if (map.containsKey(sortedStr)) {
                // Add the current string to the corresponding list
                output.get(map.get(sortedStr)).add(str);
            } else {
                // Create a new list for this sorted string and add the current string
                List<String> newList = new ArrayList<>();
                newList.add(str);
                output.add(newList);
                // Store the index of the new list in the map
                map.put(sortedStr, index);
                index++;
            }
        }

        return output;
    }
}
