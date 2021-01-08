package com.company;


/*
문자열 S는 아래와과 같은 규칙을 지킨다.

1. 알파벳 소문자('a'-'z'), 숫자('0'-'9'), 공백(' '), 특수 문자('<', '>')로만 이루어져 있다.
2. 문자열의 시작과 끝은 공백이 아니다.
3. '<'와 '>'가 문자열에 있는 경우 번갈아가면서 등장하며, '<'이 먼저 등장한다. 또, 두 문자의 개수는 같다.

태그는 '<'로 시작해서 '>'로 끝나는 길이가 3 이상인 부분 문자열이고, '<'와 '>' 사이에는 알파벳 소문자와 공백만 있다.
단어는 알파벳 소문자와 숫자로 이루어진 부분 문자열이고, 연속하는 두 단어는 공백 하나로 구분한다.
태그는 단어가 아니며, 태그와 단어 사이에는 공백이 없다.

baekjoon online judge
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class WordFlib2 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            ArrayList<String> stringArrayList = new ArrayList<>();
            String str = br.readLine();
            br.close();

            int i = 0;
            while(i < str.length()) {
                int start = i;
                if(str.charAt(i) == '<') {
                    while(str.charAt(i) != '>') {
                        i++;
                    }
                    i++;
                    stringArrayList.add(str.substring(start, i));
                }
                else if(str.charAt(i) != ' ') {
                    while(i < str.length() && str.charAt(i) != ' ' && str.charAt(i) != '<') {
                        i++;
                    }
                    String subStr = str.substring(start, i);
                    stringArrayList.add(subStr);
                    if(i < str.length() && str.charAt(i) == ' ') {
                        i++;
                        stringArrayList.add(" ");
                    }
                }
            }

            for(String string: stringArrayList) {
                if(string.charAt(0) != '<') {
                    String reverse = "";
                    for(int index = string.length() - 1; index >= 0; index--) {
                        reverse += string.charAt(index);
                    }
                    System.out.print(reverse);
                }
                else System.out.print(string);
            }


        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
