package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordStudy {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = br.readLine();
            br.close();
            int[] arr = new int['z' - 'a' + 1];
            countChar(arr, str);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void countChar(int[] arr, String str) {
        for(int i = 0; i < str.length(); i++) {
            int idx = Character.toLowerCase(str.charAt(i));
            arr[idx - 'a']++;
        }

        int maxIdx = 0, max = 0;
        for(int i = 0; i < arr.length; i++) {
            if(max < arr[i]) {
                max = arr[i];
                maxIdx = i;
            }
        }

        int dup = 0;
        for(int i = 0; i < arr.length; i++) {
            if(max == arr[i]) dup++;
        }

        if(dup != 1) System.out.println('?');
        else {
            System.out.println(Character.toUpperCase((char)(maxIdx + 'a')));
        }
    }
}
