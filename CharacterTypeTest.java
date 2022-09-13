import java.util.*;

class Solution {
    static int[][] totalScore = new int[4][2];
    static char[] type = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
    static Map<Character, Integer> types = new HashMap<>();

    public String solution(String[] survey, int[] choices) {
        String answer = "";
        initTypes();

        for(int i = 0; i < survey.length; i++) {
            int idx = 0;
            int choice = choices[i];
            int score = Math.abs(choice - 4);

            if(choice < 4) idx = types.get(survey[i].charAt(0));
            else if(choice > 4) idx = types.get(survey[i].charAt(1));

            totalScore[idx / 2][idx % 2] += score;
        }

        for(int i = 0; i < 4; i++) {
            if(totalScore[i][0] < totalScore[i][1]) answer += type[i * 2 + 1];
            else answer += type[i * 2];
        }

        return answer;
    }

    public void initTypes() {
        for(int i = 0; i < type.length; i++) types.put(type[i], i);
    }
}