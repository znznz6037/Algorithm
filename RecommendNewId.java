class Solution {
    public String solution(String new_id) {
        String answer = "";
        String s = "";

        //1
        answer = new_id.toLowerCase();

        //2
        for(int i = 0; i < answer.length(); i++) {
            char c = answer.charAt(i);
            if((c >= 'a' && c <= 'z') ||
                    (c == '-' || c == '_' || c == '.') ||
                    (c >= '0' && c <= '9')) {
                s += c;
            }
        }
        answer = s;
        s = "";

        //3
        boolean flag = false;
        for(int i = 0; i < answer.length(); i++) {
            char c = answer.charAt(i);
            if(c == '.') {
                if(!flag) {
                    flag = true;
                    s += c;
                }
            }
            else {
                if(flag) flag = false;
                s += c;
            }
        }
        answer = s;
        s = "";

        //4
        if(answer.length() > 1) {
            if(answer.charAt(0) == '.') answer = answer.substring(1, answer.length());
            if(answer.charAt(answer.length() - 1) == '.') {
                answer = answer.substring(0, answer.length() - 1);
            }
        }
        else {
            if(answer.charAt(0) == '.') answer = "";
        }

        //5
        if(answer.length() == 0) answer = "a";

        //6
        if(answer.length() >= 16) {
            answer = answer.substring(0, 15);

            if(answer.charAt(answer.length() - 1) == '.' && answer.length() != 0) {
                answer = answer.substring(0, answer.length() - 1);
            }
        }

        //7
        if(answer.length() < 3) {
            int rep = 3 - answer.length();
            char lastC = answer.charAt(answer.length() - 1);
            for(int i = 0; i < rep; i++) {
                answer += lastC;
            }
        }

        return answer;
    }
}