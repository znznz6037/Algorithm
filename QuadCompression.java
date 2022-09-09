class Solution {
    static int[] answer;
    static  boolean[][] isCompressed;

    public int[] solution(int[][] arr) {
        answer = new int[2];
        isCompressed = new boolean[arr.length][arr.length];

        divideAndConquer(arr, 0, 0, arr.length);

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if(!isCompressed[i][j]) {
                    if(arr[i][j] > 0) answer[1]++;
                    else answer[0]++;
                }
            }
        }

        return answer;
    }

    public void divideAndConquer(int[][] arr, int y, int x, int len) {
        if(len == 1 || isCompressed[y][x]) return;

        int num = arr[y][x];
        for(int i = y; i < y + len; i++) {
            for(int j = x; j < x + len; j++) {
                if(num != arr[i][j]) { //divide
                    divideAndConquer(arr, y, x, len / 2);
                    divideAndConquer(arr, y + len / 2, x, len / 2);
                    divideAndConquer(arr, y, x + len / 2, len / 2);
                    divideAndConquer(arr, y + len / 2, x + len / 2, len / 2);
                    return;
                }
            }
        }

        //conquer
        for(int i = y; i < y + len; i++) {
            for(int j = x; j < x + len; j++) {
                isCompressed[i][j] = true;
            }
        }

        if(num > 0) answer[1]++;
        else answer[0]++;

        return;
    }
}