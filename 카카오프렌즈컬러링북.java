import java.util.*;

class Pair{
    public int y, x;
    Pair(int y, int x){
        this.y = y;
        this.x = x;
    }
}

class Solution {
    static int[][] dir = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} }, visited = {};
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0;  j < n; j++){
                if(picture[i][j] != 0 && visited[i][j] == 0) {
                    maxSizeOfOneArea = Math.max(BFS(picture, i, j, m, n), maxSizeOfOneArea);
                    numberOfArea++;
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public static int BFS(int map[][], int Y, int X, int M, int N){
        Queue<Pair>q = new LinkedList<>();
        q.add(new Pair(Y, X));
        visited[Y][X] = 1;
        int color = map[Y][X];
        int size = 1;
        while(!q.isEmpty()){
            int y = q.peek().y, x = q.peek().x;
            q.poll();
            for(int idx = 0; idx < 4; idx ++){
                int ny = y + dir[idx][0], nx = x + dir[idx][1];
                if(ny < 0 || ny  >= M || nx < 0 || nx >= N || visited[ny][nx] == 1 || map[ny][nx] != color || map[ny][nx] == 0) continue;
                q.add(new Pair(ny, nx));
                visited[ny][nx] = 1;
                size++;
            }            
        }
        return size;
    }
}