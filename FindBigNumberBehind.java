import java.util.*;

class Solution {    
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<int[]> stack = new Stack<>();
        
        for(int i = 0; i < numbers.length; i++) {
            if(stack.isEmpty()) {
                answer[i] = -1;
                stack.push(new int[]{numbers[i], i});
                continue;
            }
                        
            int[] top = stack.peek();
            if(top[0] < numbers[i]) {
                while(!stack.isEmpty()) {
                    top = stack.peek();
                    if(top[0] >= numbers[i]) break;
                    
                    answer[top[1]] = numbers[i];
                    stack.pop();
                }
            }
            
            stack.push(new int[]{numbers[i], i});
        }
        
        while(!stack.isEmpty()) {
            int[] top = stack.pop();
            answer[top[1]] = -1;            
        }
        
        return answer;
    }
}
