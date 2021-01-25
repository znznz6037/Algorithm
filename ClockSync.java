package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ClockSync {

    static final int INF = 10000;
    static int solution = INF;
    static int[] map = new int[16];
    static int[][] button =
            {
                    {0, 1, 2},
                    {3, 7, 9, 11},
                    {4, 10, 14, 15},
                    {0, 4, 5, 6, 7},
                    {6, 7, 8, 10, 12},
                    {0, 2, 14, 15},
                    {3, 14, 15},
                    {4, 5, 7, 14, 15},
                    {1, 2, 3, 4, 5},
                    {3, 4, 5, 9, 13}
            };

    static void rotate(int idx) {
        for(int i = 0 ; i < button[idx].length; i++) {
            if (map[button[idx][i]] != 12) map[button[idx][i]] += 3;
            else map[button[idx][i]] = 3;
        }
    }

    static boolean isSync() {
        for(int i = 0; i < 16; i ++){
            if(map[i] != 12) return false;
        }
        return true;
    }

    static int clockSync(int swtch) {
        if(swtch == 10) {
            return isSync() ? 0 : INF;
        }

        int ret = INF;
        for(int i = 0; i < 4; i++) {
            ret = Math.min(ret, i + clockSync(swtch + 1));
            rotate(swtch);
        }
        return ret;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int N = Integer.parseInt(br.readLine());
            for(int i = 0; i < N; i++) {
                String[] clock = br.readLine().split(" ");
                for(int idx = 0; idx < 16; idx++) {
                    map[idx] = Integer.parseInt(clock[idx]);
                }

                solution = clockSync(0);
                if(solution == INF) System.out.println(-1);
                else System.out.println(solution);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
