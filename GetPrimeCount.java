import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        String converted = "";
        if(k == 10) converted = "" + n;
        else converted = transform(n, k);

        String[] numArr = converted.split("0+");
        for(String str: numArr) {
            if(isPrime(str)) answer++;
        }

        return answer;
    }

    public String transform(int n, int k) {
        StringBuilder sb = new StringBuilder();

        int len = 0;
        while(Math.pow(k, len) < n) len++;

        for(int i = len - 1; i >= 0; i--) {
            int num = 0;
            for(int j = k - 1; j >= 0; j--) {
                num = (int)(Math.pow(k, i) * j);
                if(num <= n && num != 0) {
                    n -= num;
                    sb.append(""+ j);
                    break;
                }
            }
            if(num == 0) sb.append("0");
        }
        return sb.toString();
    }

    public boolean isPrime(String str) {
        long n = Long.parseLong(str);

        if(n <= 1) return false;
        if(n == 2 || n == 3) return true;

        for(long i = 2; i <= (long)Math.sqrt(n); i++) { //Math.sqrt!!!!!!
            if(n % i == 0) return false;
        }

        return true;
    }
}