package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는
다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.

산술평균 : N개의 수들의 합을 N으로 나눈 값
중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
최빈값 : N개의 수들 중 가장 많이 나타나는 값
범위 : N개의 수들 중 최댓값과 최솟값의 차이
N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.
 */

public class Statistics {
    static int[] arr;
    static int N;

    public static void arithmeticMean(int sum) {
        System.out.printf("%.0f", sum/(double)N);
        System.out.println();
    }

    public static void median() {
        Arrays.sort(arr);
        System.out.println(arr[N / 2]);
    }

    public static void mode(int[] count) {
        int max = 0;

        for(int i = 0; i < count.length; i++) {
            if(count[i] >= max) max = count[i];
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i< count.length; i++) {
            if(count[i] == max) arrayList.add(i - 4000);
        }

        if(arrayList.size() == 1) System.out.println(arrayList.get(0));
        else System.out.println(arrayList.get(1));
    }

    public static void range() {
        System.out.println(arr[N - 1] - arr[0]);
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            int sum = 0;
            int[] count = new int[8001];
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
                sum += arr[i];
                count[arr[i] + 4000]++;
            }
            br.close();

            arithmeticMean(sum);
            median();
            mode(count);
            range();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
