/**
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

 

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 

Constraints:

1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.
**/


class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> letters = new HashMap<Character, Integer>();
        for(char letter : magazine.toCharArray()){
            letters.put(letter, letters.getOrDefault(letter, 0) + 1);
        }
        for(char letter : ransomNote.toCharArray()){
            if(letters.containsKey(letter)){
                letters.put(letter, letters.get(letter) - 1);
                if(letters.get(letter) == 0){
                    letters.remove(letter);
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
