import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        char c = s.charAt(0);
        if(c >= 97) {
            c-= 32;
        }

        answer.append(c);

        for(int i = 1; i < s.length(); i++) {
            c = s.charAt(i);

            if(s.charAt(i - 1) == ' ' && c >= 97) {
                c -= 32;
            }
            else if(s.charAt(i - 1) != ' ' && c >= 65 && c < 97) {
                c += 32;
            }

            answer.append(c);
        }

        return answer.toString();
    }
}