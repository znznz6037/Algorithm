import java.util.*;

class Pair implements Comparable<Pair>{
    public int start;
    public int end;
    public Pair(int start, int end){
        this.start = start;
        this.end = end;
    }
    public int compareTo(Pair pair){
        if(this.start > pair.start) return 1;
        else if(this.start < pair.start) return -1;
        return 0;
    }
}

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Pair[] vehicles = new Pair[routes.length];
        for(int i = 0; i < routes.length; i++) vehicles[i] = new Pair(routes[i][0], routes[i][1]);
        Arrays.sort(vehicles);
        int tmp = routes[0][1];
        for(int i = 0; i < vehicles.length - 1; i++){
            if(tmp > vehicles[i].end) tmp = vehicles[i].end;
            if(tmp < vehicles[i + 1].start){
                answer++;
                tmp = vehicles[i + 1].end;
            }
        }        
        return answer;
    }
}