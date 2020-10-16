import java.util.*;

class Solution {
    static HashMap<Character, Integer> friends;
    static int[] permutation = {};
    static boolean[] visited = {};
    static int cnt = 0;
    
    public int solution(int n, String[] data) {
        permutation = new int[8];
        visited = new boolean[8];
        friends = new HashMap<Character, Integer>();
        friends.put('A', 0);
        friends.put('C', 1);
        friends.put('F', 2);
        friends.put('J', 3);
        friends.put('M', 4);
        friends.put('N', 5);
        friends.put('R', 6);
        friends.put('T', 7);
        
        dfs(0, data);
        
        return cnt;
    }
    
    void dfs(int pos, String[] data){
        if(pos == 8){
            int f1, f2, condition;
            char compare;
            for(int i = 0; i < data.length; i++){
                f1 = permutation[friends.get(data[i].charAt(0))];
                f2 = permutation[friends.get(data[i].charAt(2))];
                compare = data[i].charAt(3);
                condition = data[i].charAt(4) - '0';
                if(compare == '='){
                    if(Math.abs(f1 - f2) - 1 != condition) return;
                }
                else if(compare == '>'){
                    if(Math.abs(f1 - f2) - 1 <= condition) return;
                }
                else if(compare == '<'){
                    if(Math.abs(f1 - f2) - 1 >= condition) return;
                }
            }
            cnt++;
            return;
        }
        for(int i = 0; i < 8; i++){
            if(!visited[i]){
                visited[i] = true;
                permutation[pos] = i;
                dfs(pos + 1, data);
                visited[i] = false;
            }
        }
    }
}