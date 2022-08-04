import java.util.*;

class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    static int maxValue = 27;

    public int[] solution(String msg) {
        initDictionary();

        return LZW(msg);
    }

    public void initDictionary() {
        char c = 'A' - 1;

        for(int i = 0; i < 26; i++) {
            c++;
            map.put("" + c, c - 'A' + 1);
        }
    }

    public int[] LZW(String msg) {
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int msgLen = msg.length();

        for(int i = 0; i < msgLen; i++) {
            String str = String.valueOf(msg.charAt(i));
            sb.append(str);

            if(!map.containsKey(sb.toString())) {
                map.put(sb.toString(), maxValue++);
                String s = sb.substring(0, sb.length() - 1);
                if(map.containsKey(s)) list.add(map.get(s));
                sb.setLength(0);
                i--;
            }
        }

        if(map.containsKey(sb.toString())) list.add(map.get(sb.toString()));

        int rep = 0;
        int[] answer = new int[list.size()];
        for(int index: list) answer[rep++] = index;

        return answer;
    }
}