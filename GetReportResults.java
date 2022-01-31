import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int len = id_list.length;

        int[] answer = new int[len];
        int[][] adj = new int[len][len]; //인접행렬 adj[신고자][피신고자]

        HashMap<String, Integer> idIdx = new HashMap<>();
        for(int i = 0; i < len; i++) {
            idIdx.put(id_list[i], i);
        }

        HashMap<String, Integer> reported = new HashMap<>(); //신고 당한 횟수
        for(String repoStr: report) {
            String[] info = repoStr.split(" ");
            if(adj[idIdx.get(info[0])][idIdx.get(info[1])] == 0) {
                adj[idIdx.get(info[0])][idIdx.get(info[1])] = 1;
                reported.put(info[1], reported.getOrDefault(info[1], 0) + 1);
            }
        }

        for(Map.Entry<String, Integer> entry: reported.entrySet()) {
            if(entry.getValue() >= k) {
                int ansIdx = idIdx.get(entry.getKey());
                for(int i = 0; i < len; i++) {
                    if(adj[i][ansIdx] == 1)
                        answer[i]++;
                }
            }
        }

        return answer;
    }
}