import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[col - 1] == o2[col - 1]) return o2[0] - o1[0];
                return o1[col - 1] - o2[col - 1];                
            }
        });
        
        int[] S = new int[data.length + 1];
        for(int i = row_begin; i <= row_end; i++) {
            for(int j = 0; j < data[0].length; j++) {
                S[i] += data[i - 1][j] % (i);
            }
        }
        
        for(int i = row_begin; i <= row_end; i++) {
            if(i == row_begin) {
                answer = S[i];
                continue;
            }
            
            answer = answer ^ S[i];
        }
        
        return answer;
    }
}
