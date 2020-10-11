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