import java.util.*;

class Solution {
    static ArrayList<String> subsetList = new ArrayList<String>();

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        ArrayList<String> answerList = new ArrayList<>();
        for(int len: course) {
            for(String str: orders) {
                combination(str.length(), len, 0, 0, new boolean[str.length()], new int[len], str);
            }

            HashMap<String, Integer> map = new HashMap<String, Integer>();
            for(String sub: subsetList) {
                map.put(sub, map.getOrDefault(sub, 0) + 1);
            }

            Map.Entry<String, Integer > maxEntry = null;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) maxEntry = entry;
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if(maxEntry.getValue() == entry.getValue() && entry.getValue() > 1) {
                    answerList.add(entry.getKey());
                    System.out.println(entry.getKey());
                }
            }

            subsetList.clear();
        }

        answer = answerList.toArray(new String[answerList.size()]);
        Arrays.sort(answer);
        return answer;
    }

    public void combination(int n, int r, int start, int depth, boolean[] visited, int[] answer, String order) {
        if(n < r) return;
        if(depth == r) {
            String str = "";
            for(int idx: answer) str += order.charAt(idx);
            char[] toCharArr = str.toCharArray();
            Arrays.sort(toCharArr);
            subsetList.add(new String(toCharArr));
            return;
        }

        for(int i = start; i < n; i++) {
            visited[i] = true;
            answer[depth] = i;
            combination(n, r, i + 1, depth + 1, visited, answer, order);
            visited[i] = false;
            answer[depth] = 0;
        }
    }
}