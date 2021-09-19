class Solution {
    public String solution(int[][] scores) {
        String answer = "";
        int len = scores[0].length;

        for(int i = 0; i < len; i++) {
            int headCount = len;
            float sum = 0;
            boolean maxFlag = true, minFlag = true;

            for(int j = 0; j < len; j++) {
                sum += scores[j][i];
                if(i == j) continue;

                if(scores[j][i] >= scores[i][i]) maxFlag = false;
                if(scores[j][i] <= scores[i][i]) minFlag = false;
            }

            if(maxFlag || minFlag) {
                sum -= scores[i][i];
                --headCount;
            }

            sum /= headCount;
            answer += sum >= 90 ? "A" : sum >= 80 ? "B" : sum >= 70 ? "C" : sum >= 50 ? "D" : "F";
        }

        return answer;
    }
}