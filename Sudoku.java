import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Sudoku {
    static int[][] map = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String[] str = (br.readLine().split(" "));
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        br.close();

        fillSudoku(0, 0);
    }

    public static void fillSudoku(int y, int x) {
        if(x == 9) {
            fillSudoku(y + 1, 0);
            return;
        }

        if(y == 9) {
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }

            System.exit(0);
        }

        if(map[y][x] == 0) {
            for(int i = 1; i <= 9; i++) {
                if (canFill(y, x, i)) {
                    map[y][x] = i;
                    fillSudoku(y, x + 1);
                }
            }
            map[y][x] = 0;
            return;
        }

        fillSudoku(y, x + 1);
    }

    public static boolean canFill(int y, int x, int value) {
        if(checkLinear(x, value, true) && checkLinear(y, value, false) && checkSquare(y, x, value)) return true;
        return false;
    }

    public static boolean checkLinear(int idx, int value, boolean isCol) {
        for(int i = 0; i < 9; i++) {
            if(!isCol && map[idx][i] == value) return false;
            else if(isCol && map[i][idx] == value) return false;
        }

        return true;
    }

    public static boolean checkSquare(int y, int x, int value) {
        int startY = (y / 3) * 3, startX = (x / 3) * 3;

        List<Integer> numList = new ArrayList<>();
        for(int i = 1; i <= 9; i++) numList.add(i);

        for(int i = startY; i < startY + 3; i++) {
            for(int j = startX; j < startX + 3; j++) {
                if(map[i][j] == value) return false;
            }
        }

        return true;
    }
}
