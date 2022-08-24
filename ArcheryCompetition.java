import java.util.*;

class Solution {
    static int cnt;
    static int score;
    static int[] apeach;
    static List<int[]> answerList;

    public int[] solution(int n, int[] info) {
        int[] answer = {};
        cnt = n;
        apeach = info;
        score = 0;
        answerList = new ArrayList<>();

        boolean[] visited = new boolean[11];
        int[] ryan = new int[11];
        DFS(visited, ryan, 0);

        if(answerList.size() == 0 || score == 0) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        else return answerList.get(answerList.size() - 1);
    }

    public int getScore(int[] ryan) {
        int rscore = 0;
        int ascore = 0;
        for(int i = 0; i < 11; i++) {
            if(ryan[i] > apeach[i]) rscore += (10 - i);
            else if(ryan[i] < apeach[i]) ascore += (10 - i);
        }

        return rscore - ascore;
    }

    public void DFS(boolean[] visited, int[] ryan, int rep) {
        if(rep > cnt) return;
        if(rep == cnt) {
            int result = getScore(ryan);
            if(result >= score) {
                int[] arr = new int[11];
                for(int i = 0; i < 11; i++) {
                    arr[i] = ryan[i];
                }

                answerList.add(arr);
                score = result;
            }

            return;
        }

        for(int i = 0; i < 11; i++) {
            if(!visited[i]) {
                visited[i] = true;
                ryan[i] = apeach[i] + 1;
                if(i == 10) ryan[i] = cnt - rep;

                DFS(visited, ryan, rep + ryan[i]);

                visited[i] = false;
                ryan[i] = 0;
            }
        }

        return;
    }
}