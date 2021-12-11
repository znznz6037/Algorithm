class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()) stack.push(s.charAt(i));
            else {
                switch(s.charAt(i)) {
                    case ')':
                        if(stack.peek() == '(') stack.pop();
                        else stack.push(s.charAt(i));
                        break;
                    case ']':
                        if(stack.peek() == '[') stack.pop();
                        else stack.push(s.charAt(i));
                        break;
                    case '}':
                        if(stack.peek() == '{') stack.pop();
                        else stack.push(s.charAt(i));
                        break;
                    default:
                        stack.push(s.charAt(i));
                        break;
                }
            }
        }

        if(stack.isEmpty()) return true;
        return false;
    }

}