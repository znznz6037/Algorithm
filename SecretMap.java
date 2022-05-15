import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] encrtyped1 = encrypt(arr1);
        String[] encrtyped2 = encrypt(arr2);

        for(int y = 0; y < n; y++) {
            StringBuilder sb = new StringBuilder();
            for(int x = 0; x < n; x++) {
                if(encrtyped1[y].charAt(x) == '1' || encrtyped2[y].charAt(x) == '1') sb.append('#');
                else sb.append(' ');
            }

            answer[y] = sb.toString();
        }

        return answer;
    }

    public String[] encrypt(int[] nums) {
        String[] encrypted = new String[nums.length];

        for(int i = 0; i < nums.length; i++) {
            encrypted[i] = decimalToBinary(nums[i], nums.length);
        }

        return encrypted;
    }

    public String decimalToBinary(int num, int n) {
        StringBuilder binary = new StringBuilder();
        for(int i = n - 1; i >= 0; i--) {
            double square = Math.pow(2, i);
            if(square <= num) {
                num -= square;
                binary.append('1');
            }
            else binary.append('0');
        }

        return binary.toString();
    }
}