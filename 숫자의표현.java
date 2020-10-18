class Solution {
    public int solution(int n) {
        int answer = 1;
        answer += number(n);
        return answer;
    }
    
    int number(int n) {
        int answer = 0, num = 1;
        while(num <= n / 2){
            int sum = 0;
            for(int i = num; i <= (n / 2) + 1; i++){
                sum += i;
                if(sum == n) {
                    answer++;
                    break;
                }
                if(sum > n) break;
            }
            num++;
        }
        return answer; 
    }
}
