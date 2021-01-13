package com.company;

public class Boggle {
    static char[][] map = {
            {'U', 'R', 'L', 'P', 'M'},
            {'X', 'P', 'R', 'E', 'T'},
            {'G', 'I', 'A', 'E', 'T'},
            {'X', 'T', 'N', 'Z', 'Y'},
            {'X', 'O', 'Q', 'R', 'S'}
    };

    static int[][] dir = {
            {-1, -1}, {-1, 1}, {-1, 0}, {0, -1}, {0, 1}, {1, 0}, {1, -1}, {1, 1}
    };

    public static void main(String[] args) {
        System.out.println(hasWord(1, 1, "PRETTY"));
    }

    public static boolean inRange(int y, int x) {
        if(y < 0 || y > 4 || x < 0 || x > 4) return false;
        else return true;
    }

    public static boolean hasWord(int y, int x, String word) {
        if(!inRange(y, x)) return false;

        if(map[y][x] != word.charAt(0)) return false;

        if(word.length() == 1) return true;

        for(int i = 0; i < 8; i++) {
            int ny = y + dir[i][0];
            int nx = x + dir[i][1];

            if(hasWord(ny, nx, word.substring(1))) return true;
        }

        return false;
    }
}
