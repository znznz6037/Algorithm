class Solution {
    static int[] answer = new int[2];
    public int[] solution(int brown, int yellow) {
        for(int i = yellow; i >= (yellow / i); i--){
            if(yellow % i != 0) continue;
            if((2 * i) + (2 * yellow / i) + 4 == brown){
                answer[0] = i + 2;
                answer[1] = yellow / i + 2;
                break;
            }
        }
        return answer;
    }
}
/*
가로 >= 세로
12
12 * 1
6 * 2 
4 * 3
*/