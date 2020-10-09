import java.util.*;

class Pair{
    public int y, x;
    
    public Pair(int y, int x){
        this.y = y;
        this.x = x;
    }
    public int first() {
        return this.y;
    }
    public int second() {
        return this.x;
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer>q = new LinkedList<>();
	    ArrayList<Pair>pass = new ArrayList<>();
		int answer = 1, cur_weight = 0;
        for(int i = 0; i < truck_weights.length; i++) q.add(truck_weights[i]);
        //맨 처음 트럭 추가 
        pass.add(new Pair(q.peek(), bridge_length));
        cur_weight = q.poll();
        
        while(!q.isEmpty() || !pass.isEmpty()) {
            int mass = 0;
            // 무게가 초과되지 않으면 트럭 추가
            if(!q.isEmpty() && cur_weight + q.peek() <= weight) {
                mass = q.poll();
                cur_weight += mass;
                pass.add(new Pair(mass, bridge_length));
            }
            //다리 위 트럭들 거리 1씩 감소
            if(!pass.isEmpty()) {
                for(int i = 0; i < pass.size(); i++) {
                    int remain = pass.get(i).second() - 1;
                    if(remain <= 0) {
                        cur_weight -= pass.get(i).first();
                        pass.remove(i);
                        if(i > 0) i--;
                    }
                    if(pass.isEmpty()) continue;
                    pass.set(i, new Pair(pass.get(i).first(), pass.get(i).second() - 1));
                }
            }
            answer++;
        }
        return answer;
    }
}