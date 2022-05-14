import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int rep = 0;
        int[] answer = new int[2];
        ArrayList<String> wordList = new ArrayList<>();

        for(int i = 0; i < words.length; i++) {
            if(i % n == 0) rep++;

            if(!isCorrect(words, i)) return makeAnswer(i % n + 1, rep);

            if(!wordList.contains(words[i])) wordList.add(words[i]);
            else return makeAnswer(i % n + 1, rep);
        }

        return answer;
    }

    public boolean isCorrect(String[] words, int idx) {
        if(idx == 0) return true;
        if(words[idx].length() == 1) return false;

        int prevIdx = idx - 1;
        if(words[prevIdx].charAt(words[prevIdx].length() - 1) != words[idx].charAt(0)) return false;

        return true;
    }

    public int[] makeAnswer(int idx, int rep) {
        int[] answer = {idx, rep};
        return answer;
    }
}