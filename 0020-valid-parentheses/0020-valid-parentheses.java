class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){

            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }

            else{
                if(stack.isEmpty()){
                    return false;
                }

                 char top = stack.pop();

                if (ch == ')' && top != '(') {
                    return false;
                }

                if (ch == '}' && top != '{') {
                    return false;
                }

                if (ch == ']' && top != '[') {
                    return false;
                }
            }
        }

        // Valid only if no opening brackets are left
        return stack.isEmpty();
    }
}