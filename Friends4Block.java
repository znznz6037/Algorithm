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

    public int[][] dir = {
            {0, 1},
            {1, 0},
            {1, 1}
    };

    public int solution(int m, int n, String[] board) {
        char[][] charBoard = new char[m][n];

        for(int i = 0; i < m; i++) {
            charBoard[i] = board[i].toCharArray();
        }

        while(true) {
            int cnt = 0;
            boolean[][] deleted = new boolean[m][n];
            for(int i = 0; i < m - 1; i++) {
                for(int j = 0; j < n - 1; j++) {
                    cnt += checkSquare(i, j, charBoard, deleted);
                }
            }
            if(cnt == 0) {
                return retAnswer(charBoard);
            }

            execDelete(charBoard, deleted);
        }
    }

    public int checkSquare(int y, int x, char[][] cBoard, boolean[][] deleted) {
        char friend = cBoard[y][x];
        if(friend == ' ') return 0;

        int ny = 0, nx = 0;
        Queue<Pos> queue =new LinkedList<>();
        queue.add(new Pos(y, x));
        for(int i = 0; i < 3; i++) {
            ny = y + dir[i][0];
            nx = x + dir[i][1];
            if(cBoard[ny][nx] == friend) queue.add(new Pos(ny, nx));
            else return 0;
        }

        while(!queue.isEmpty()) {
            Pos pos = queue.poll();
            deleted[pos.y][pos.x] = true;
        }

        return 1;
    }

    public void execDelete(char[][] cBoard, boolean[][] deleted) {
        int len = cBoard[0].length;
        int height = cBoard.length;

        for(int x = 0; x < len; x++) {
            for(int y = height - 1; y >= 0; y--) {
                if(deleted[y][x]) {
                    int ly = y;
                    while(deleted[ly][x] && ly > 0) {
                        cBoard[ly][x] = ' ';
                        ly--;
                    }
                    if(deleted[0][x]) cBoard[0][x] = ' ';
                    deleted[ly][x] = true;
                    cBoard[y][x] = cBoard[ly][x];
                    cBoard[ly][x] = ' ';
                }
            }
        }
    }

    public int retAnswer(char[][] cBoard) {
        int answer = 0;
        for(int i = 0; i < cBoard.length; i++) {
            for(int j = 0; j < cBoard[0].length; j++) {
                if(cBoard[i][j] == ' ') answer++;
            }
        }

        return answer;
    }
}