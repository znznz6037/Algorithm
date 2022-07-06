/*
n이 최대 10^7 이고, n^2 최대 10^14이므로 완전 탐색 시 시간초과/메모리초과

n = 6 일 때, 이차원 배열 arr[n][n] 로 변환했다고 가정하고
1 2 3 4 5 6 / 2 2 3 4 5 6 / 3 3 3 4 "5" 6 / 4 4 4 4 5 6 / 5 5 5 5 5 6 / 6 6 6 6 6 6

arr[0] = (1) 2 3 4 5 6
arr[1] = (2 2) 3 4 5 6
arr[2] = (3 3 3) 4 5 6
arr[3] = (4 4 4 4) 5 6
arr[4] = (5 5 5 5 5) 6
arr[5] = (6 6 6 6 6 6)

규칙
idx / n 의 몫이 나머지보다 큰 경우: 배열[idx] = 몫 + 1
idx / n 의 몫이 나머지보다 작은 경우: 배열[idx] = 나머지 + 1
*/
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];

        int idx = 0;
        long quotient = 0;
        long remainder = 0;

        for(long i = left; i <= right; i++) {
            quotient = i / n;
            remainder = i % n;

            if(remainder >= quotient) answer[idx++] = (int)remainder + 1;
            else answer[idx++] = (int)quotient + 1;
        }

        return answer;
    }
}