class Solution {
    public String reverseVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        Stack<Character> reverse = new Stack<>();
        StringBuilder result = new StringBuilder();
        
        vowels.add('a');
        vowels.add('A');
        vowels.add('e');
        vowels.add('E');
        vowels.add('i');
        vowels.add('I');
        vowels.add('u');
        vowels.add('U');
        vowels.add('o');
        vowels.add('O');

        for(Character c : s.toCharArray()){
            if(vowels.contains(c)){
                reverse.push(c);
            }
        }

        for(var i = 0; i < s.length(); i++){
            if(vowels.contains(s.charAt(i))){
                result.append(reverse.pop());
            }else{
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
