class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int rowLen = board.length;
        int colLen = board[0].length;
        int[][] prefixSum = new int[rowLen + 1][colLen + 1];

        for(int[] phase: skill) {
            phase[5] = phase[0] == 1 ? phase[5] * -1: phase[5];
            prefixSum[phase[1]][phase[2]] += phase[5];
            prefixSum[phase[1]][phase[4] + 1] -= phase[5];
            prefixSum[phase[3] + 1][phase[2]] -= phase[5];
            prefixSum[phase[3] + 1][phase[4] + 1] += phase[5];
        }

        //가로 누적합
        for(int i = 0; i < rowLen + 1; i++) {
            for(int j = 0; j < colLen; j++) {
                prefixSum[i][j + 1] += prefixSum[i][j];
            }
        }

        //세로 누적합
        for(int j = 0; j < colLen + 1; j++) {
            for(int i = 0; i < rowLen; i++) {
                prefixSum[i + 1][j] += prefixSum[i][j];
            }
        }

        for(int i = 0; i < rowLen; i++) {
            for(int j = 0; j < colLen; j++) {
                if(board[i][j] + prefixSum[i][j] > 0) answer++;
            }
        }

        return answer;
    }
}