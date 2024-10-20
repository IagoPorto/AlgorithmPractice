class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (c == ',') {
                continue;
            } else if (c != ')') {
                stack.push(c);
            } else {
                int tCount = 0, fCount = 0;
                while (stack.peek() != '(') {
                    char top = stack.pop();
                    if (top == 't') tCount++;
                    else if (top == 'f') fCount++;
                }
                stack.pop(); // pop the '('
                char operator = stack.pop();
                
                if (operator == '&') {
                    stack.push(fCount > 0 ? 'f' : 't');
                } else if (operator == '|') {
                    stack.push(tCount > 0 ? 't' : 'f');
                } else if (operator == '!') {
                    stack.push(fCount > 0 ? 't' : 'f');
                }
            }
        }

        return stack.pop() == 't';
    }
}
