import java.util.*;

class Solution {
    static char[] op = {'+', '-', '*'};
    static List<Character> operators;
    static List<Long> numList;
    static long answer;

    public long solution(String expression) {
        answer = 0;
        numList = new ArrayList<>();
        operators = new ArrayList<>();

        for(int i = 0; i < expression.length(); i++) {
            if((expression.charAt(i) < '0' || expression.charAt(i) > '9')) {
                operators.add(expression.charAt(i));
            }
        }

        String[] number = expression.split("\\D");
        for(String str: number) numList.add(Long.parseLong(str));

        boolean[] visited = new boolean[3];
        DFS("", visited, 0);

        return answer;
    }

    public long calc(long num1, long num2, char c) {
        long num = 0;

        switch(c) {
            case '+': {
                return num1 + num2;
            }

            case '-': {
                return num1 - num2;
            }

            case '*': {
                return num1 * num2;
            }
        }

        return num;
    }

    public void DFS(String str, boolean[] visited, int cnt) {
        if(cnt == 3) {
            List<Long> nums = new ArrayList<>(numList);
            List<Character> opList = new ArrayList<>(operators);

            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < opList.size(); j++) {
                    if(str.charAt(i) == opList.get(j)) {
                        long num = calc(nums.remove(j), nums.remove(j), str.charAt(i));
                        nums.add(j, num);
                        opList.remove(j);
                        j--;
                    }
                }
            }

            answer = Math.max(answer, Math.abs(nums.get(0)));
            return;
        }

        for(int i = 0; i < 3; i++) {
            if(!visited[i]) {
                visited[i] = true;
                DFS(str + op[i], visited, cnt + 1);
                visited[i] = false;
            }
        }
    }


}