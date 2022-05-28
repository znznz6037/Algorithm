import java.util.*;

class Solution {

    class Coord {
        int y;
        int x;
        int dist;

        public Coord(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }

    int[][] dir = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for(int i = 0; i < 5; i++) {
            int partialAns = 0;
            if(isRoomIsolated(places[i])) {
                partialAns = 1;
            }

            answer[i] = partialAns;
        }

        return answer;
    }

    public int getManhattanDist(Coord coord1, Coord coord2) {
        return Math.abs(coord1.y - coord2.y) + Math.abs(coord1.x - coord2.x);
    }

    public boolean isRoomIsolated(String[] room) {

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(room[i].charAt(j) == 'P') {
                    if(!isPersonIsolated(new Coord(i, j, 0), room)) return false;
                }
            }
        }

        return true;
    }

    public boolean isPersonIsolated(Coord coord, String[] room) {
        //파티션으로 안 막혀있다면, 맨해튼 거리가 3 이상인 경우만 true
        Queue<Coord> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        queue.add(coord);

        Coord curCoord = new Coord(coord.y, coord.x, 0);
        while(!queue.isEmpty()) {
            curCoord = queue.poll();
            int curY = curCoord.y;
            int curX = curCoord.x;
            int curDist = curCoord.dist;
            int nextY = 0;
            int nextX = 0;
            visited[curY][curX] = true;

            for(int i = 0; i < 4; i++) {
                char nextPlace = ' ';
                nextY = curY + dir[i][0];
                nextX = curX + dir[i][1];

                if(nextY >= 0 && nextY < 5 && nextX >= 0 && nextX < 5 && !visited[nextY][nextX]) {
                    nextPlace = room[nextY].charAt(nextX);

                    if(nextPlace == 'P') {
                        int manhattanDist = getManhattanDist(coord, new Coord(nextY, nextX, curDist + 1));
                        if(manhattanDist < 3) {
                            if(curDist + 1 < 3) return false;
                        }
                    }

                    else if(nextPlace != 'X') queue.add(new Coord(nextY, nextX, curDist + 1));
                }
            }
        }

        return true;
    }
}