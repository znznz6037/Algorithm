import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++){
            answer[i] = sorting(array, commands[i]);
        }
        return answer;
    }
    
    int sorting(int[] array, int[] command){
        int [] arr = new int[command[1] - command[0] + 1];
        int idx = 0;
        for(int i = command[0] - 1; i < command[1]; i++){
            arr[idx] = array[i];
            idx++;
        }
        Arrays.sort(arr);
        return arr[command[2] - 1];
    }
}
