import java.util.*;

class Solution {
    public static int length, width;
    public static int id = 0;
    public static int[][] visited;
    public static Map<Integer, Integer> countMap;
    
    class Pos {
        int y;
        int x;
        
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    int[][] dir = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    
    public int solution(int[][] land) {
        int answer = 0;
        
        length = land.length;
        width = land[0].length;
        visited = new int[length][width];
        countMap = new HashMap<>();
        
        for(int i = 0; i < width; i++) {
            int count = 0;
            Map<Integer, Integer> visitedMap = new HashMap<>();
            for(int j = 0; j < length; j++) {
                if(land[j][i] == 0) continue;
                
                if(visited[j][i] == 0) { //처음 방문한 구역
                    int result = bfs(j, i, land);
                    count += result;
                    countMap.put(id, result);
                    visitedMap.put(visited[j][i], visited[j][i]);
                }
                else { //이미 계산 완료된 구역은 메모이제이션
                    int sectorId = visitedMap.getOrDefault(visited[j][i], 0);
                    if(sectorId == 0) { //방문한 적 없으면 count 추가
                        count += countMap.getOrDefault(visited[j][i], 0);
                        visitedMap.put(visited[j][i], visited[j][i]);
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        
        return answer;
    }
    
    public int bfs(int y, int x, int[][] land) {
        id++;
        int count = 0;
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(y, x));
        visited[y][x] = id;
        
        while(!queue.isEmpty()) {
            Pos curPos = queue.poll();
            count++;
            
            for(int i = 0; i < 4; i++) {
                int ny = curPos.y + dir[i][0];
                int nx = curPos.x + dir[i][1];
                
                if(ny < 0 || ny >= length || nx < 0 || nx >= width) continue;
                if(land[ny][nx] == 0) continue;
                if(visited[ny][nx] != 0) continue;
                
                queue.add(new Pos(ny, nx));
                visited[ny][nx] = id;
            }
        }
        
        return count;
    }
}
