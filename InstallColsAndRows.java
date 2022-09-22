class Solution {
    int count = 0;
    boolean[][] rows;
    boolean[][] cols;

    public int[][] solution(int n, int[][] build_frame) {
        rows = new boolean[n + 3][n + 3];
        cols = new boolean[n + 3][n + 3];

        for(int[] phase: build_frame) build(n, phase);

        int idx = 0;
        int[][] answer = new int[count][3];

        for(int x = 1; x <= n + 1; x++) {
            for(int y = 1; y <= n + 1; y++) {
                if(cols[y][x]) answer[idx++] = new int[]{x - 1, y - 1, 0};
                if(rows[y][x]) answer[idx++] = new int[]{x - 1, y - 1, 1};
            }
        }

        return answer;
    }

    public void build(int n, int[] phase) {
        int x = phase[0] + 1;
        int y = phase[1] + 1;
        int a = phase[2];
        int b = phase[3];

        if(b == 0) {
            if(a == 0) cols[y][x] = false;
            else rows[y][x] = false;
            count--;

            if(!canRemove(n)) {
                if(a == 0) cols[y][x] = true;
                else rows[y][x] = true;
                count++;
            }
        }
        else {
            if(a == 0 && isPossibleCol(x, y)) {
                cols[y][x] = true;
                count++;
            }
            else if(a == 1 && isPossibleRow(x, y)) {
                rows[y][x] = true;
                count++;
            }
        }
    }

    public boolean isPossibleCol(int x, int y) {
        if(y == 1 || cols[y - 1][x] || rows[y][x - 1] || rows[y][x]) return true;
        return false;
    }

    public boolean isPossibleRow(int x, int y) {
        if(cols[y - 1][x] || cols[y - 1][x + 1] || rows[y][x - 1] && rows[y][x + 1]) return true;
        return false;
    }

    public boolean canRemove(int n) {
        for(int i = 1; i <= n + 1; i++) {
            for(int j = 1; j <= n + 1; j++) {
                if(cols[i][j] && !isPossibleCol(j, i)) return false;
                if(rows[i][j] && !isPossibleRow(j, i)) return false;
            }
        }

        return true;
    }
}