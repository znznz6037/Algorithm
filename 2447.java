import java.util.Scanner;

public class MakeStar {
    static char[][] stars;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        stars = new char[N][N];
        recursion(N, 0, 0, false);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(stars[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void recursion(int n, int Y, int X, boolean vacant) {
        if(n <= 3) {
            for(int i = Y; i < Y + 3; i++) {
                for(int j = X; j < X + 3; j++) {
                    if(vacant) stars[i][j] = ' ';
                    else {
                        if(i == Y + 1 && j == X + 1) stars[i][j] = ' ';
                        else stars[i][j] = '*';
                    }
                }
            }

            return;
        }

        int interval = n / 3;
        for(int y = Y; y < Y + n; y += interval) {
            for(int x = X; x < X + n; x += interval) {
                if(y == Y + interval && x == X + interval) recursion(interval, y, x, true);
                else recursion(interval, y, x, vacant);
            }
        }
    }
}
