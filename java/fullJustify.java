/**
Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left-justified, and no extra space is inserted between words.

Note:

    A word is defined as a character sequence consisting of non-space characters only.
    Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
    The input array words contains at least one word.

 

Example 1:

Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]

Example 2:

Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
Note that the second line is also left-justified because it contains only one word.

Example 3:

Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]

 

Constraints:

    1 <= words.length <= 300
    1 <= words[i].length <= 20
    words[i] consists of only English letters and symbols.
    1 <= maxWidth <= 100
    words[i].length <= maxWidth


**/

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> text = new ArrayList<>();
        int currentSize = 0;
        List<String> line = new ArrayList<>();
        for(String word : words){
            if(currentSize + line.size() + word.length() > maxWidth){
                    text.add(this.fullJustifyAux(words, maxWidth, currentSize, line));
                    line = new ArrayList<>();
                    line.add(word);
                    currentSize = word.length();
            }else{
                line.add(word);
                currentSize += word.length();
            }
        }
        text.add(this.leftJustify(line, currentSize, maxWidth));
        return text;
    }

    private String fullJustifyAux(String[] words, int maxWidth, int currentSize, List<String> line){
        int spaces = maxWidth - currentSize;
        int extraSpaces = spaces % (line.size() > 1 ? line.size() - 1 : 1);
        int normalSpaces = spaces / (line.size() > 1 ? line.size() - 1 : 1);
        System.out.println(normalSpaces);
        StringBuilder sb = new StringBuilder();
        int j = 1;
        for(String word : line){
            sb.append(word);
            if(j < line.size() || line.size() == 1){
                for(int i = 0; i < normalSpaces; i++){
                    sb.append(" ");
                }
                if(extraSpaces > 0){
                    sb.append(" ");
                    extraSpaces--;
                }
            }
            j++;
        }
        return sb.toString();

    }

    private String leftJustify(List<String> line, int currentSize, int maxWidth){
        StringBuilder sb = new StringBuilder();
        int spaces = maxWidth - currentSize;
        for(String word : line){
            sb.append(word);
            if(spaces > 0){
                sb.append(" ");
                spaces--;
            }
        }
        for(int i = 0; i < spaces; i++){
            sb.append(" ");
        }
        return sb.toString();
    }
}
