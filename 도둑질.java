class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int[] dp1 = new int[money.length + 2];
        int[] dp2 = new int[money.length + 2];
        dp1[2] = money[0];
        dp2[3] = money[1];
        for(int i = 1; i < money.length; i++){
            if(i < money.length - 1) dp(money, dp1, i);
            if(i > 1) dp(money, dp2, i);
            answer = Math.max(Math.max(answer, dp1[i + 2]), dp2[i + 2]);
        }
        return answer;
    }
    
    void dp(int[] money, int result[], int i){
        if(result[i] > result[i - 1]){
            result[i + 2] = money[i] + result[i];
        }
        else result[i + 2] = money[i] + result[i - 1];
    }
}