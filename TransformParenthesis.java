import java.util.*;

class Solution {
    public String solution(String p) {
        return makeCompleteParen(p);
    }

    public String makeCompleteParen(String p) {
        //1. 빈 문자열이면 빈 문자열 반환
        if(p == " ") return "";
        if(isCompleteParen(p)) return p;

        //2. 균형잡힌 문자열 두 개로 분리
        //u는 무조건 더 이상 분리할 수 없는 균형잡힌 문자열, v는 빈 문자열이 될 수 있음
        String[] sArr = new String[2];
        sArr = divideToBalancedParen(p);
        String u = sArr[0];
        String v = sArr[1];

        //3. u가 올바른 괄호이면 v에 대해 1단계부터 다시 수행
        if(isCompleteParen(u)) {
            String subAnswer = makeCompleteParen(v);
            return u + subAnswer;
        }

        //4. u가 올바른 괄호가 아니라면
        //4-1. 빈 문자열에 '(' 삽입
        //4-2. v에 대해 1단계부터 수행한 결과 append
        //4-3. ')' 붙이기
        v = "(" + makeCompleteParen(v) + ")";

        //4-4. u의 첫, 마지막 문자 제거 후 괄호 뒤집어서 뒤에 append
        u = reversedParen(u.substring(1, u.length() - 1));

        //4-5. 문자열 리턴
        return v + u;
    }

    public String[] divideToBalancedParen(String p) {
        String[] sArr = new String[2];
        int balanced = 0;
        int idx = 0;
        for(idx = 0; idx < p.length(); idx++) {
            if(p.charAt(idx) == '(') balanced++;
            else balanced--;
            if(balanced == 0) break;
        }
        sArr[0] = p.substring(0, idx + 1);
        if(idx != p.length()) sArr[1] = p.substring(idx + 1, p.length());
        return sArr;
    }

    public boolean isCompleteParen(String p) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < p.length(); i++) {
            if(stack.isEmpty()) {
                stack.push(p.charAt(i));
                continue;
            }

            if(stack.peek() == '(' && p.charAt(i) == ')') stack.pop();
            else stack.push(p.charAt(i));
        }

        if(stack.isEmpty()) return true;
        return false;
    }

    public String reversedParen(String p) {
        String str = "";
        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(') str += ')';
            else str += '(';
        }

        return str;
    }
}