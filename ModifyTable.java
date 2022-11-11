import java.util.*;

class Solution {
    private class Node {
        int pre;
        int cur;
        int nxt;

        public Node(int pre, int cur, int nxt) {
            this.pre = pre;
            this.cur = cur;
            this.nxt = nxt;
        }
    }

    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];
        for(int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;

        Stack<Node> stack = new Stack<>();
        StringBuilder answer = new StringBuilder("O".repeat(n));

        for(String command: cmd) {
            char c = command.charAt(0);
            if(c == 'U') {
                int offset = Integer.valueOf(command.substring(2));
                while(offset-- > 0) {
                    k = prev[k];
                }
            }
            else if(c == 'D') {
                int offset = Integer.valueOf(command.substring(2));
                while(offset-- > 0) {
                    k = next[k];
                }
            }
            else if(c == 'C') {
                stack.push(new Node(prev[k], k, next[k]));
                if(prev[k] != -1) next[prev[k]] = next[k];
                if(next[k] != -1) prev[next[k]] = prev[k];
                answer.setCharAt(k, 'X');

                if(next[k] != -1) k = next[k];
                else k = prev[k];
            }
            else {
                Node node = stack.pop();
                answer.setCharAt(node.cur, 'O');

                if(node.pre != -1) next[node.pre] = node.cur;
                if(node.nxt != -1) prev[node.nxt] = node.cur;
            }
        }
        return answer.toString();
    }
}