//피보나치
class Solution {
    public int solution(int n) {
        int[] result = new int[n + 1];
        result[1] = 1;
        result[2] = 2;
        for(int i = 3; i <= n; i++) {
            result[i] = (result[i - 1] + result[i - 2]) % 1000000007;
        }
        return result[n];
    }
}