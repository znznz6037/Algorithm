import java.util.*;

class Solution {
    static List<int[]> list = new ArrayList<>();

    public int[][] solution(int n) {
        hanoi(n, 1, 2, 3);
        int[][] answer = new int[list.size()][2];

        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public void hanoi(int n, int from, int via, int to) {
        int[] route = {from, to};

        if(n == 1) list.add(route);
        else {
            hanoi(n - 1, from, to, via);
            list.add(route);
            hanoi(n - 1, via, from, to);
        }
    }
}