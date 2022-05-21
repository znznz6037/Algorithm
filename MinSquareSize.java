import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        return calMinSize(sizes);
    }

    public int calMinSize(int[][] sizes) {
        for(int i = 0; i < sizes.length; i++) {
            if(sizes[i][0] < sizes[i][1]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }

        int[] width = new int[sizes.length];
        int[] height = new int[sizes.length];

        for(int i = 0; i < sizes.length; i++) {
            width[i] = sizes[i][0];
            height[i] = sizes[i][1];
        }

        Arrays.sort(width);
        Arrays.sort(height);

        return width[sizes.length - 1] * height[sizes.length - 1];
    }
}