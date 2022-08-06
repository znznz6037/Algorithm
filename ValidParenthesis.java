import java.util.*;

class Solution {
    boolean solution(String s) {
        return isValid(s);
    }

    boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ')' && !stack.isEmpty()) stack.pop();
            else stack.push(s.charAt(i));
        }

        if(stack.isEmpty()) return true;
        return false;
    }
}