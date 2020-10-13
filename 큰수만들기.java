class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int cnt = k;
        int left = 0, right = number.length();
        int idx = 0;
        if(number.charAt(0) == '0') return "0";
        for(int i = 0; i < number.length() - k; i++) {
            char max = '0';
            for(int j = idx; j <= k + i; j++) {
                if(number.charAt(j) > max){
                    max = number.charAt(j);
                    idx = j + 1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }
}