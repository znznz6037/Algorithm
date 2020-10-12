import java.util.*;

class Solution {
    //n개 없애서 바위 간 거리 최솟값 중 최대값 구하기
    //n개 없앴을 때 바위 간 거리 최대 값. 
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        return binarySearch(distance, rocks, n);        
    }
    
    int binarySearch(int distance, int[] rocks, int n){
        int left = 1, right = distance, mid = 0;
        int answer = 0;
        while(left <= right){
            int standard = 0, cnt = 0;
            mid = (left + right) / 2;
            for(int i = 0; i < rocks.length; i++){
                if(rocks[i] - standard < mid) cnt++; // 현재 최대값보다 작은 값이 있으므로 돌 제거                
                else standard = rocks[i];
            }
            if(distance - standard < mid) cnt++; // 마지막 돌과 도착지점 비교
            
            if(cnt <= n){ // 더
                answer = answer > mid ? answer : mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return answer;
    }
}