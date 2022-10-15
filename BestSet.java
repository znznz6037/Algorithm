class Solution {
    public int[] solution(int n, int s) {
        if(n > s) return new int[]{ -1 };

        int[] answer = new int[n];
        int minValue = s / n;
        int mid = s - (minValue * n);


        for(int i = 0; i < n; i++){
            if(i >= n - mid) answer[i] = minValue + 1;
            else answer[i] = minValue;
        }

        return answer;
    }
}