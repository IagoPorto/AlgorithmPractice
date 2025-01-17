class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c != '*'){
                stack.push(c);
            }else{
                stack.pop();
            }
        }

        char[] result = new char[stack.size()];
        int i = stack.size() - 1;
        while(!stack.isEmpty()) {
            result[i] = stack.pop();
            i--;
        }
        return new String(result);
    }
}
