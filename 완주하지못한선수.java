import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> list = new HashMap<>();
        for(String s: participant) list.put(s, list.getOrDefault(s, 0) + 1);
        for(String s: completion) list.put(s, list.get(s) - 1);
        for(String key: list.keySet()){
            if(list.get(key) != 0)
                return key;
        }
        return answer;
    }
}