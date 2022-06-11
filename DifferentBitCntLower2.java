import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            }
            else {
                StringBuilder ans = new StringBuilder();
                String binary = Long.toBinaryString(numbers[i]);

                if(binary.contains("0")) {
                    int lastIndexOfZero = binary.lastIndexOf("0");
                    int firstIndexOfOne = binary.indexOf("1", lastIndexOfZero);

                    ans.append(binary, 0, lastIndexOfZero).append("1");
                    ans.append("0");
                    ans.append(binary.substring(firstIndexOfOne + 1));

                    answer[i] = Long.parseLong(ans.toString(), 2);
                }
                else {
                    ans.append("10");
                    ans.append(binary.substring(1).replace("0", "1"));

                    answer[i] = Long.parseLong(ans.toString(), 2);
                }
            }

        }

        return answer;
    }
}