import java.util.*;

class Solution {
    static String route = "";
    static boolean[] visited = {};
    static ArrayList<String> list = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        for(int i = 0; i < tickets.length; i++){
            visited = new boolean[tickets.length];
            if(!visited[i] && tickets[i][0].equals("ICN")){
                route = tickets[i][0] + ","; ///// route += tickets[i][0] + ","; 해서 틀림 -> 이거 때문에 경로 초기화 X
                visited[i] = true;
                dfs(tickets, tickets[i][1], 1);
            }
        }
        
        Collections.sort(list);
        answer = list.get(0).split(",");
        return answer;
    }
    
    void dfs(String[][] tickets, String end, int cnt){
        route += end + ",";
        if(cnt == tickets.length) {
            list.add(route);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(end)){
                visited[i] = true;
                dfs(tickets, tickets[i][1], cnt + 1);
                visited[i] = false;
                route = route.substring(0, route.length() - 4);
            }
        }
        return;
    }
}