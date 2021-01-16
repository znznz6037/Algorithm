package com.company;

import java.util.Scanner;

public class Hansu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;
        for(int i = 1; i <= N; i++)
            result += hanSu(i);

        System.out.println(result);
    }

    public static int hanSu(int N) {
        String str = Integer.toString(N);
        if(str.length() < 3) return 1;
        int ap = str.charAt(1) - str.charAt(0);
        for(int i = 0; i < str.length() - 1; i++) {
            if(str.charAt(i + 1) - str.charAt(i) != ap) return 0;
        }
        return 1;
    }

}
