import java.util.*;

class Pair{
    int y, x;
    public Pair(int y, int x) {
        this.y = y;
        this.x =x;
    }
    public int first() {
        return this.y;
    }
    public int second() {
        return this.x;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        ArrayList<Pair> printer = new ArrayList<>();
        for(int i = 0; i < priorities.length; i++) {
            printer.add(new Pair(priorities[i], i));
        }
        int idx = 0;
        while(true) {
            idx++;
            for(int i = 0; i < printer.size(); i++) {
                Pair tmp = null;
                for(int j = 0; j < printer.size(); j++) {
                    if(printer.get(0).first() < printer.get(j).first()){
                        tmp = printer.get(0);
                        printer.remove(0);
                        break;
                    }
                }
                if(tmp != null) printer.add(tmp);
            }
            if(printer.get(0).second() == location) {
                answer = idx;
                break;
            }
            printer.remove(0);
        }
        return answer;
    }
}