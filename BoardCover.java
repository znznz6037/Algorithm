package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
입력
3
3 7
#.....#
#.....#
##...##
3 7
#.....#
#.....#
##..###
8 10
##########
#........#
#........#
#........#
#........#
#........#
#........#
##########

출력
0
2
1514
 */

public class BoardCover {
    static int dir[][][] = {
            {{0, 0}, {1, 0}, {1, -1}},
            {{0, 0}, {0, 1}, {1, 1}},
            {{0, 0}, {1, 0}, {1, 1}},
            {{0, 0}, {1, 0}, {0, 1}}
    };

    static int H, W;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int C = Integer.parseInt(br.readLine());
            for(int i = 0; i < C; i++) {
                String[] input = br.readLine().split(" ");
                int H = Integer.parseInt(input[0]), W = Integer.parseInt(input[1]);
                int[][] map = new int[H][W];
                for(int row = 0; row < H; row++) {
                    String arr = br.readLine();
                    for(int col = 0; col < W; col++) {
                        if(arr.charAt(col) == '#') map[row][col] = 1;
                        else map[row][col] = 0;
                    }
                }
                System.out.println(cover(map));
            }
            br.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean inRange(int y, int x) {
        if(y < 0 || y >= H || x < 0 || x >= W) return false;
        else return true;
    }

    public static boolean setMap(int[][] map, int y, int x, int type, int check) {
        boolean result = true;

        for(int i = 0; i < 3; i++) {
            int ny = y + dir[type][i][0];
            int nx = x + dir[type][i][1];
            if(!inRange(ny, nx)) result = false;
            else if((map[ny][nx] += check) > 1) result = false;
        }
        return result;
    }

    public static int cover(int[][] map) {
        int y = -1, x = -1;

        for(int row = 0; row < H; row++) {
            for (int col = 0; col < W; col++) {
                if(map[row][col] == 0) {
                    y = row;
                    x = col;
                    break;
                }
            }
            if(y != -1) break;
        }

        if(y == - 1)return 1;

        int ans = 0;
        for(int i = 0; i < 4; i++) {
            if(setMap(map, y, x, i, 1)) ans += cover(map);
            setMap(map, y, x, i, -1);
        }

        return ans;
    }
}
