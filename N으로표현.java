class Solution {
    static int answer = -1;
    public int solution(int N, int number) {
        dfs(N, number, 0, 0);
        return answer;
    }
    
    void dfs(int N, int number, int cnt, int value){
        int tmp = N;
        if(cnt > 8){
            answer = -1;
            return;
        }
        if(number == value){
            if(answer == -1 || answer > cnt){
                answer = cnt;
            }
            return;
        }
        for(int i = 0; i < 8 - cnt; i++){
            dfs(N, number, cnt + i + 1, value + tmp);
            dfs(N, number, cnt + i + 1, value - tmp);
            dfs(N, number, cnt + i + 1, value * tmp);
            dfs(N, number, cnt + i + 1, value / tmp);
            tmp = tmp * 10 + N;
        }
    }
}