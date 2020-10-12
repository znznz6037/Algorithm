import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        return binarySearch(n, times, times[times.length - 1]);
    }
    
    long binarySearch(int n, int[] times, long max){ //int max 해서 틀림
        long start = 1;
        long end = max * n;
        long mid = 0;
        long answer = Long.MAX_VALUE;
        while(start <= end){
            mid = (start + end) / 2;
            if(isPassed(n, times, mid)){
                answer = answer > mid ? mid : answer;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return answer;
    }
    
    boolean isPassed(int n, int[] times, long mid){
        long amount = 0;
        for(int i = 0; i < times.length; ++i){
            amount += mid / times[i];
        }
        if(amount >= n) return true;
        else return false;
    }
}