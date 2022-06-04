import java.util.*;

class Solution {
    public ArrayList<Integer> key;

    public int solution(String[][] relation) {
        key = new ArrayList<Integer>();
        boolean[] visited = new boolean[relation[0].length];

        for(int i = 0; i < relation[0].length; i++) {
            dfs(0, 0, i + 1, visited, relation);
        }

        return key.size();
    }

    public void dfs(int start, int cnt, int len, boolean[] visited, String[][] relation) {
        if(cnt == len) {
            ArrayList<Integer> colIdxList = new ArrayList<>();

            for(int i = 0; i < visited.length; i++) {
                if(visited[i]) colIdxList.add(i);
            }

            checkCandidateKey(colIdxList, relation);
        }

        for(int i = start; i < visited.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i, cnt + 1, len, visited, relation);
                visited[i] = false;
            }
        }
    }

    public void checkCandidateKey(ArrayList<Integer> colIdxList, String[][] relation) {
        for(int i = 0; i < relation.length - 1; i++) {
            for(int j = i + 1; j < relation.length; j++) {
                boolean isDup = true;
                for(int idx: colIdxList) {
                    if(!relation[i][idx].equals(relation[j][idx])) isDup = false;
                }
                if(isDup) return;
            }
        }

        int keyValue = 0;
        for(int i = 0; i < colIdxList.size(); i++) {
            keyValue += Math.pow(2, colIdxList.get(i));
        }

        if(isMinimal(keyValue)) key.add(keyValue);
    }

    //비트 연산을 통해 최소성 만족 여부 체크
    public boolean isMinimal(int keyValue) {
        for(int i: key) {
            if((keyValue & i) == i) return false;
        }

        return true;
    }
}