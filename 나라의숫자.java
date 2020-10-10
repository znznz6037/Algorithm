class Solution {
    static String num[] = {"4", "1", "2"};
    public String solution(int n) {
        int number = n;
		String answer = "";
		while(number > 0) {
			int remainder = number % 3;
			number /= 3;
			if(remainder == 0) number--;
			answer = num[remainder] + answer;
		}
        return answer;
    }
}
