class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int period;
        for(int i = 0; i < prices.length - 1; i++) {
			period = 0;
			int j = i + 1;
			if(j == prices.length) answer[j] = 0;
			else {
				while(j < prices.length) {
					period++;
					if(prices[i] > prices[j]) break;
					j++;
				}			
				answer[i] += period;
			}
		}
        return answer;
    }
}