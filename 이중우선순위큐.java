import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        ArrayList<Integer> q = new ArrayList<>();
        for(int i = 0; i < operations.length; i++){
            String[] arr = operations[i].split(" ");
            int oper = 0;
            if(arr[0].equals("I")){
                oper = Integer.parseInt(arr[1]);
                q.add(oper);
                q.sort(Comparator.naturalOrder());
            }
            else{
                if(q.isEmpty()) continue;
                oper = Integer.parseInt(arr[1]);
                if(oper > 0) { // 최댓값 삭제
                    q.remove(q.size() - 1);
                }
                else{ // 최솟값 삭제
                    q.remove(0);
                }
            }
        }
        int[] answer = new int[2];
        if(q.isEmpty()) return answer;
        else{
            answer[0] = q.get(q.size() - 1);
            answer[1] = q.get(0);
            return answer;
        }
    }
}