import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();

        int numIdx = 0; //현재 숫자의 string index
        int cnt = 0; //모든 사람이 말한 총 숫자 수
        int num = 0; // 현재 말하고 있는 숫자
        String number = "";
        for(int len = 0; len < t;) {
            if(number.equals("") || numIdx == number.length()) {
                number = transform(n, num);
                num++;
                numIdx = 0;
            }

            if(cnt == p - 1) {
                len++;
                answer.append(number.charAt(numIdx));
                p += m;
            }

            numIdx++;
            cnt++;
        }

        return answer.toString();
    }

    public String transform(int nth, int num) {
        if(num == 0) return "0";
        if(num == 1) return "1";

        int len = 0;
        StringBuilder sb = new StringBuilder();

        while(Math.pow(nth, len) <= num) len++;

        for(int i = len - 1; i >= 0; i--) {
            int cur = 0;
            for(int j = nth - 1; j >= 0; j--) {
                cur = (int)(Math.pow(nth, i) * j);
                if(num >= cur && cur != 0) {
                    num -= cur;
                    if(j >= 10) {
                        char c = 'A';
                        c += j - 10;
                        sb.append("" + c);
                    }
                    else sb.append("" + j);
                    break;
                }
            }
            if(cur == 0) sb.append("0");
        }

        return sb.toString();
    }
}