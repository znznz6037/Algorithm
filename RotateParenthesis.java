import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        for(int i = 0; i < s.length(); i++) {
            if(isProperParen(shiftLeft(s, i))) answer++;
        }

        return answer;
    }

    public String shiftLeft(String s, int n) {
        if(n == 0) return s;

        String shifted = "";
        for(int i = 0; i < s.length(); i++) {
            if(n >= s.length()) n = 0;

            shifted += s.charAt(n);
            n++;
        }

        return shifted;
    }

    public boolean isProperParen(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!stack.isEmpty()) {
                if(stack.peek() == '(' && c == ')') {
                    stack.pop();
                }
                else if(stack.peek() == '[' && c == ']') {
                    stack.pop();
                }
                else if(stack.peek() == '{' && c == '}') {
                    stack.pop();
                }
                else stack.add(c);
            }
            else stack.add(c);
        }

        if(stack.isEmpty()) return true;
        else return false;
    }
}