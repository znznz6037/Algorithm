import java.util.*;

public class 기능개발 {
	public static void main(String args[]) {
		int progresses[] = {30, 30, 20, 10, 10, 5};
		int []speeds = {1, 1, 1, 10, 1, 1};
		
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		ArrayList<Integer> deploy = new ArrayList<Integer>();
		ArrayList<Integer> sp = new ArrayList<Integer>();
		
		for(int i = 0; i < progresses.length; i++) {
			deploy.add(progresses[i]);
			sp.add(speeds[i]);
		}
		int cnt = 0;
		while(true) {
			for(int i = 0; i < deploy.size(); i++) deploy.set(i, deploy.get(i) + sp.get(i));
			for(int i = 0; i < deploy.size(); i++) {
				if(deploy.get(i) < 100) break;
				cnt++;
				deploy.remove(i); sp.remove(i);
				i--;
			}
			if(cnt != 0) {
				tmp.add(cnt);
				cnt = 0;
			}
			if(deploy.isEmpty()) break;
		}
		int idx = 0;
		int[] answer = new int[tmp.size()];
		for(int i : tmp) answer[idx++] = i;
		for(int i : answer) System.out.println(i);
	}
}
