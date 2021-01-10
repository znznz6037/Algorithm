package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SortInside {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        String num = Integer.toString(N);
        Character[] arr = new Character[num.length()];

        for(int i = 0; i < num.length(); i++) {
            arr[i] = num.charAt(i);
        }

        Arrays.sort(arr, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if(o1 > o2) return -1;
                else if(o1 < o2) return 1;
                else return 0;
            }
        });

        for(char c: arr) System.out.print(c);
    }
}
