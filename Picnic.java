package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Picnic {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int C = Integer.parseInt(br.readLine());
            for (int i = 0; i < C; i++) {
                String[] str = br.readLine().split(" ");
                int n = Integer.parseInt(str[0]), m = Integer.parseInt(str[1]);
                boolean[][] friends = new boolean[n][n];

                str = br.readLine().split(" ");
                for(int index = 0; index < str.length; index += 2) {
                    int firstIndex = Integer.parseInt(str[index]);
                    int secondIndex = Integer.parseInt(str[index + 1]);
                    friends[firstIndex][secondIndex] = friends[secondIndex][firstIndex] = true;
                }
                boolean[] isPicked = new boolean[n];
                System.out.println(countingPair(isPicked, friends, n));
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static int countingPair(boolean isPicked[], boolean[][] friends, int n) {
        int first = -1;
        for(int i = 0; i < n; i++) {
            if(!isPicked[i]) {
                first = i;
                break;
            }
        }

        if(first == -1) return 1;

        int cnt = 0;

        for(int i = first + 1; i < n; i++) {
            if (!isPicked[i] && friends[first][i]) {
                isPicked[first] = isPicked[i] = true;
                cnt += countingPair(isPicked, friends, n);
                isPicked[first] = isPicked[i] = false;
            }
        }
        return cnt;
    }
}
