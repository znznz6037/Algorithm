import java.util.*;

class Solution {
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
            {-1 , 0}
    };

    class VisitedPath {
        int y1;
        int x1;
        int y2;
        int x2;

        public VisitedPath(int y1, int x1, int y2, int x2) {
            this.y1 = y1;
            this.x1 = x1;
            this.y2 = y2;
            this.x2 = x2;
        }

        public boolean equals(Object object) {
            VisitedPath visitedPath = (VisitedPath)object;

            if(visitedPath.y1 == this.y1 && visitedPath.x1 == this.x1 && visitedPath.y2 == this.y2 && visitedPath.x2 == this.x2) return true;
            return false;
        }
    }

    static Pos curPos;
    static ArrayList<VisitedPath> visitedPath;

    public int solution(String dirs) {
        int answer = 0;
        curPos = new Pos(5, 5);
        visitedPath = new ArrayList<VisitedPath>();
        for(int i = 0; i < dirs.length(); i++) {
            answer += move(dirs.charAt(i));
        }
        return answer;
    }

    public int move(char c) {
        int answer = 0;
        int[] curDir = dir[direction(c)];
        int ny = curPos.y + curDir[0];
        int nx = curPos.x + curDir[1];
        if(ny >= 0 && ny < 11 && nx >= 0 && nx < 11) {
            if(!(visitedPath.contains(new VisitedPath(curPos.y, curPos.x, ny, nx)) ||
                    visitedPath.contains(new VisitedPath(ny, nx, curPos.y, curPos.x)))) answer++;
            visitedPath.add(new VisitedPath(curPos.y, curPos.x, ny, nx));
            curPos = new Pos(ny, nx);
        }
        return answer;
    }

    public int direction(char c) {
        switch(c) {
            case 'R':
                return 0;
            case 'L':
                return 1;
            case 'D':
                return 2;
            case 'U':
                return 3;
            default:
                return 0;
        }
    }
}