import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i < clothes.length; i++)
            hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 1) + 1);
        
        for(int i: hm.values())
            answer *= i;
        
        return answer - 1;
    }
}