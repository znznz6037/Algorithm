import java.util.*;

class Solution {

    public int[] solution(int[][] edges) {
        /*
        막대 그래프
        나가는 간선없이 들어오는 간선 정점 존재 시

        8자 그래프
        들어오는 간선, 나가는 간선 모두 2개 이상인 정점 존재 시

        도넛 그래프
        생성한 정점에서 나가는 간선의 수(= 그래프의 총 개수 이므로)에서 - (막대 개수 + 8자 개수)
        */
        
        int[] answer = new int[4];
        Map<Integer, int[]> map = new HashMap<>();

        for(int[] edge: edges) {
            if(!map.containsKey(edge[0])) map.put(edge[0], new int[2]);
            if(!map.containsKey(edge[1])) map.put(edge[1], new int[2]);

            int[] out = map.get(edge[0]);
            int[] in = map.get(edge[1]);
            out[1] += 1;
            in[0] += 1;

            map.put(edge[0], out);
            map.put(edge[1], in);
        }

        Iterator<Map.Entry<Integer, int[]>> it = map.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<Integer, int[]> entry = it.next();

            int[] inOut = entry.getValue();
            if(inOut[0] == 0 && inOut[1] >= 2) answer[0] = entry.getKey();
            if(inOut[0] > 0 && inOut[1] == 0) answer[2]++;
            if(inOut[0] >= 2 && inOut[1] >= 2) answer[3]++;
        }

        answer[1] = map.get(answer[0])[1] - answer[2] - answer[3];

        return answer;
    }
}
