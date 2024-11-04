/**

Given a string word, compress it using the following algorithm:

    Begin with an empty string comp. While word is not empty, use the following operation:
        Remove a maximum length prefix of word made of a single character c repeating at most 9 times.
        Append the length of the prefix followed by c to comp.

Return the string comp.

 

Example 1:

Input: word = "abcde"

Output: "1a1b1c1d1e"

Explanation:

Initially, comp = "". Apply the operation 5 times, choosing "a", "b", "c", "d", and "e" as the prefix in each operation.

For each prefix, append "1" followed by the character to comp.

Example 2:

Input: word = "aaaaaaaaaaaaaabb"

Output: "9a5a2b"

Explanation:

Initially, comp = "". Apply the operation 3 times, choosing "aaaaaaaaa", "aaaaa", and "bb" as the prefix in each operation.

    For prefix "aaaaaaaaa", append "9" followed by "a" to comp.
    For prefix "aaaaa", append "5" followed by "a" to comp.
    For prefix "bb", append "2" followed by "b" to comp.

 

Constraints:

    1 <= word.length <= 2 * 105
    word consists only of lowercase English letters.




Intuition

To solve this problem, I thought about breaking the string into segments based on repeated characters. The goal is to count how many times a character appears consecutively, but we must limit that count to a maximum of 9. This approach allows us to efficiently compress the string by capturing these counts and their corresponding characters.
Approach

    Initialize a StringBuilder to store the compressed result.

    Iterate through the string using an index:

    For each character, count how many times it repeats consecutively (up to 9).
    Append the count and the character to the StringBuilder.

    Continue until the end of the string is reached.
    Finally, return the compressed string.

Complexity

    Time complexity: O(n)

    Space complexity: O(n)

Code
**/
class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int  index = 0;
        while(index < word.length()){
            int  count = 0;
            char c = word.charAt(index);
            count++;
            index++;
            while(index < word.length() && c == word.charAt(index)){
                count++;
                index++;
                if(count == 9){
                    break;
                }
            }

            comp.append(count);
            comp.append(c);

        }

        return comp.toString();
    }
}
