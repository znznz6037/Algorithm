class Solution {
    public int solution(int n) {
        int answer = calPrimeCnt(n);
        return answer;
    }

    public int calPrimeCnt(int n) {
        int cnt = 0;
        boolean[] arr = new boolean[n + 1];

        for(int i = 2; i <= n; i++) {
            if(arr[i]) continue;

            for(int j = i * 2; j <= n; j += i) {
                arr[j] = true;
            }
        }

        for(int i = 2; i <= n; i++) {
            if(!arr[i]) cnt++;
        }

        return cnt;
    }
}