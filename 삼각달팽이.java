class Solution {
    public int[] solution(int n) {
        int triangle[][] = new int[n][n];
        int max = (n * (n + 1)) / 2;
        int[] answer = new int[max];
        int state = 0;
        int num = 1;
        int top = 0, left = 0, right = 0, bottom = n - 1;
        while(max >= num){
            if(state == 0){
                for(int i = top; i <= bottom; i ++) triangle[i][left] = num++;
                top++;
                left++;
                state = 1;
            }
            else if(state == 1){
                for(int i = left; i <= bottom - right; i++) triangle[bottom][i] = num++;
                bottom--;
                state = 2;
            }
            else if(state == 2){
                for(int i = bottom; i >= top; i--) triangle[i][i - right] = num++;
                top++;
                right++;
                state = 0;
            }
        }
        int idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(triangle[i][j] > 0) answer[idx++] = triangle[i][j];
            }
        }
        return answer;
    }
}