import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class NGE {
    static class Num {
        int index;
        int value;

        Num(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[N];

        Stack<Num> stack = new Stack<>();
        Stack<Num> temp = new Stack<>();
        Stack<Num> answerStack = new Stack<>();

        String[] str = br.readLine().split(" ");
        br.close();

        for(int i = N - 1; i >= 0; i--) stack.add(new Num(i, Integer.parseInt(str[i])));

        while(!stack.isEmpty()) {
            if(temp.isEmpty()) temp.add(stack.pop());
            else if(stack.peek().value > temp.peek().value) {
                answerStack.add(new Num(temp.peek().index, stack.peek().value));
                temp.pop();
            }
            else temp.add(stack.pop());
        }

        while(!temp.isEmpty()) {
            answerStack.add(new Num(temp.pop().index, -1));
        }

        while(!answerStack.isEmpty()) {
            Num num = answerStack.pop();
            answer[num.index] = num.value;
        }

        StringBuilder sb = new StringBuilder();
        for(int i: answer) sb.append(i + " ");
        System.out.println(sb);

        return;
    }
}
