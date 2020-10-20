import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Character> answer;
	static HashMap<Character, Integer> hm;
	public static void main(String[] args) {
		try {
			hm = new HashMap<>();
			hm.put('*', 2);
			hm.put('/', 2);
			hm.put('+', 1);
			hm.put('-', 1);
			hm.put('(', 0);
			answer = new ArrayList<>();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String infix = br.readLine();
			
			postfix(infix);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	static void postfix(String infix) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < infix.length(); i++) {
			switch(infix.charAt(i)) {
				case '(':
					stack.add(infix.charAt(i));
					break;
				case ')':
					while(!stack.isEmpty()) {
						if(stack.peek() == '(') {
							stack.pop();
							break;
						}
						answer.add(stack.pop());
					}
					break;
				case '*':
					while(!stack.isEmpty() && priority('*', stack.peek())) answer.add(stack.pop());
					stack.add(infix.charAt(i));
					break;
				case '/':
					while(!stack.isEmpty() && priority('/', stack.peek())) answer.add(stack.pop());
					stack.add(infix.charAt(i));
					break;
				case '+':
					while(!stack.isEmpty() && priority('+', stack.peek())) answer.add(stack.pop());
					stack.add(infix.charAt(i));
					break;
				case '-':
					while(!stack.isEmpty() && priority('-', stack.peek())) answer.add(stack.pop());
					stack.add(infix.charAt(i));
					break;
				default :
					answer.add(infix.charAt(i));
					break;
			}
		}
		while(!stack.isEmpty()) {
			answer.add(stack.pop());
		}
		String str = "";
		for(char s : answer) {
			str += s;
		}
		System.out.println(str);
	}
	
	static boolean priority(char c, char top) {
		int a = hm.get(c);
		int b = hm.get(top);
		return a <= b;
	}
}