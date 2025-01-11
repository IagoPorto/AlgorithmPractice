/*Two strings are considered close if you can attain one from the other using the following operations:

Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.

 

Example 1:

Input: word1 = "abc", word2 = "bca"
Output: true
Explanation: You can attain word2 from word1 in 2 operations.
Apply Operation 1: "abc" -> "acb"
Apply Operation 1: "acb" -> "bca"
Example 2:

Input: word1 = "a", word2 = "aa"
Output: false
Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
Example 3:

Input: word1 = "cabbba", word2 = "abbccc"
Output: true
Explanation: You can attain word2 from word1 in 3 operations.
Apply Operation 1: "cabbba" -> "caabbb"
Apply Operation 2: "caabbb" -> "baaccc"
Apply Operation 2: "baaccc" -> "abbccc"
 

Constraints:

1 <= word1.length, word2.length <= 105
word1 and word2 contain only lowercase English letters.*/

class Solution {
    public boolean closeStrings(String word1, String word2) {

        if(word1.length() != word2.length()){
            return false;
        }

        Map<Character, Integer> charsWord1 = new HashMap<>();
        Map<Character, Integer> charsWord2 = new HashMap<>();

        for(char c : word1.toCharArray()){
            if(charsWord1.containsKey(c)){
                charsWord1.put(c, charsWord1.get(c) + 1);
            }else{
                charsWord1.put(c, 1);
            }
        }

        for(char c : word2.toCharArray()){
            if(charsWord2.containsKey(c)){
                charsWord2.put(c, charsWord2.get(c) + 1);
            }else{
                charsWord2.put(c, 1);
            }
        }

        Set<Character> chars1 = charsWord1.keySet();
        Set<Character> chars2 = charsWord2.keySet();

        if(!chars1.equals(chars2)) return false;

        List<Integer> occurrences1 = new ArrayList<>(charsWord1.values());
        List<Integer> occurrences2 = new ArrayList<>(charsWord2.values());

        Collections.sort(occurrences1);
        Collections.sort(occurrences2);

        return occurrences1.equals(occurrences2);

    }
}
