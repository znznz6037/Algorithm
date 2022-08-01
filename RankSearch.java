import java.util.*;

class Solution {
    static HashMap<String, List<Integer>> map;

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();

        for(int i = 0; i < info.length; i++) makeSentence("", info[i].split(" "), 0);

        for(String key: map.keySet()) Collections.sort(map.get(key));

        for(int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] q = query[i].split(" ");

            answer[i] = map.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0;
        }

        return answer;
    }

    public int binarySearch(String key, int score) {
        List<Integer> scoreList = new ArrayList<>();
        scoreList = map.get(key);

        int left = 0, right = scoreList.size() - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(scoreList.get(mid) < score) {
                left = mid + 1;
            }
            else right = mid - 1;
        }

        return scoreList.size() - left;
    }

    public void makeSentence(String key, String[] info, int cnt) {
        if(cnt == 4) {
            int score = Integer.parseInt(info[4]);

            if(!map.containsKey(key)) {
                List<Integer> scoreList = new ArrayList<>();
                map.put(key, scoreList);

            }
            map.get(key).add(score);
            return;
        }

        makeSentence(key + info[cnt], info, cnt + 1);
        makeSentence(key + "-", info, cnt + 1);
    }
}