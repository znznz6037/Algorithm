package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class AlignWord {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            //String[] strArr = new String[N];
            ArrayList<String> stringArrayList = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                //strArr[i] = br.readLine();
                String str = br.readLine();
                if(!stringArrayList.contains(str)) stringArrayList.add(str);
            }
            br.close();

            /*1. 길이가 짧은 것부터
            2. 길이가 같으면 사전 순으로*/
            Collections.sort(stringArrayList, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if(o1.length() < o2.length()) return -1;
                    else if(o1.length() == o2.length()) return o1.compareTo(o2);
                    else return 1;
                }
            });

            /*Arrays.sort(strArr, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if(o1.length() < o2.length()) return -1;
                    else if(o1.length() == o2.length()) return o1.compareTo(o2);
                    else return 1;
                }
            });*/

            for(String str: stringArrayList) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
