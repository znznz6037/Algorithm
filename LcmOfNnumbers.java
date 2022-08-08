import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;

        Arrays.sort(arr);
        int len = arr.length;
        int biggest = arr[len - 1];

        boolean isAnswer = false;
        while(!isAnswer) {
            biggest += arr[len - 1];

            for(int i = 0; i < len; i++) {
                if(biggest % arr[i] == 0) isAnswer = true;
                else {
                    isAnswer = false;
                    break;
                }
            }
        }

        return biggest;
    }
}