import java.util.*;

class Solution {

    public int[] solution(String s) {
        int[] answer = new int[2];

        ArrayList<Integer> deletedZeroCnt = new ArrayList<>();
        int prevLength = 0;
        int deletedLength = 0;

        while(true) {
            if(s.length() == 1) break;

            prevLength = s.length();

            //1. 0 제거
            s = deleteZero(s);

            //0 제거한 문자열 길이
            deletedLength = prevLength - s.length();
            deletedZeroCnt.add(deletedLength);

            //2. 0 제거한 2진수로 변환
            s = toBinary(s.length());
        }

        answer[0] = deletedZeroCnt.size();
        for(int cnt: deletedZeroCnt) answer[1] += cnt;

        return answer;
    }

    public String deleteZero(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') sb.append("1");
        }

        return sb.toString();
    }

    public String toBinary(int len) {
        String binary = Integer.toBinaryString(len);
        return binary;
    }
}