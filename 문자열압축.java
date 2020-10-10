import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 10000;
        for(int i = 1; i <= s.length(); i++){
            int result = strLength(s, i);
            if(answer > result) answer = result;
        }
        return answer;
    }
    public static int strLength(String s, int len){
        ArrayList<String> arr = stringCompression(s, len);
        Iterator<String> iter = arr.iterator();
        String result = "";
        String prev = "";
        int cnt = 1;
        while(iter.hasNext()){
            String curStr = iter.next();
            if(cnt >= 1 && !iter.hasNext() && prev.equals(curStr)) {
                cnt++;
                result = result.substring(0, result.length() - prev.length());
                result += Integer.toString(cnt) + curStr;
                break;
            }
            if(prev.equals(curStr)) cnt++;
            else {
                if(cnt > 1) {
                //if(cnt > 1 && iter.hasNext()){ 이 조건 때문에 틀렸었음
                    result = result.substring(0, result.length() - prev.length());
                    result += Integer.toString(cnt) + prev + curStr;
                    cnt = 1;
                }
                else result += curStr;
                prev = curStr;
            }
        }
        return result.length();
    }
    
    public static ArrayList<String> stringCompression(String str, int compLength){
        ArrayList<String> arr = new ArrayList<>();
        for(int i = 0; i <= str.length(); i += compLength){
            String s = "";
            if(i + compLength >= str.length()){
                arr.add(str.substring(i));
                break;
            }
            for(int j = i; j < i + compLength; j++) s += str.charAt(j);
            arr.add(s);
        }
        return arr;
    }
}