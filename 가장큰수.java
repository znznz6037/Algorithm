import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> firstNum = new ArrayList<>(10);
    public String solution(int[] numbers) {
        String answer = "";
        String[] strNum = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) strNum[i] = String.valueOf(numbers[i]);
        Arrays.sort(strNum, new Comparator<String>(){
            public int compare(String s1, String s2){
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        if(strNum[0].equals("0")) answer += "0";
        else{
            for(int i = 0; i < numbers.length; i++){
                answer += strNum[i];
            }
        }
        return answer;
    }
}
