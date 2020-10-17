import java.util.*;

class Solution {
    // 만약 서로 다른 폰켓몬의 종류가 N / 2보다 크다 -> 키 개수 - N/2 리턴
    // 종류가 N / 2보다 작다 -> 키 개수 리턴
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) hm.put(nums[i], hm.getOrDefault(i, 0) + 1);
        
        for(int i: hm.keySet()) answer++;
        
        if(answer > nums.length / 2) return nums.length / 2;
        return answer;
    }
}