package com.company;

import java.util.Scanner;

public class Director {
    public static int solution(int N) {
        int doom = 666;
        int count = 1;

        while(count != N) {
            doom++;
            if(String.valueOf(doom).contains("666")) {
                count++;
            }
        }
        return doom;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        System.out.println(solution(N));
    }
}
