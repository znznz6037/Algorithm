import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = BFS(numbers, target);
        return answer;
    }
    
    public int BFS(int[] numbers, int target) {
        Queue<Integer> q = new LinkedList<>();
        int result = 0;
        int idx = 1;
        q.add(numbers[0]);
        q.add(numbers[0] * (-1));
        while(idx < numbers.length) {
            int qSize = q.size();
            while(qSize > 0){
                int n = q.poll();
                q.add(n + numbers[idx]);
                q.add(n - numbers[idx]);
                qSize--;
            }
            idx++;
        }
        
        while(!q.isEmpty()){
            int elem = q.poll();
            if(elem == target) result++;
        }
        return result;
    }
}

/* DFS 풀이 추가
import java.util.*;

class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {       
        DFS(numbers, target, 0, 0, 0);
        return answer;
    }
    
    static void DFS(int[] numbers, int target, int idx, int sum, int cnt) {
        if(cnt == numbers.length) {
            if(sum == target) {
                answer++;
            }    
            return;
        }
        
        DFS(numbers, target, idx + 1, sum + numbers[idx], cnt + 1);
        DFS(numbers, target, idx + 1, sum - numbers[idx], cnt + 1);   
    }
}
*/
