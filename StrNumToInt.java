class Solution {
    public int solution(String s) {

        String str = "";
        boolean isChar = false;
        int startIdx = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                if(isChar) {
                    str += returnNum(s.substring(startIdx, i));
                }

                str += s.charAt(i);
            }
            else {
                if(!isChar) {
                    isChar = true;
                    startIdx = i;
                }
                else {
                    String partialStr = returnNum(s.substring(startIdx, i + 1));
                    if(!partialStr.equals("NaN")) {
                        isChar = false;
                        str += partialStr;
                    }
                }
            }
        }

        return Integer.parseInt(str);
    }

    String returnNum(String str) {
        switch(str) {
            case "zero":
                return "0";
            case "one":
                return "1";
            case "two":
                return "2";
            case "three":
                return "3";
            case "four":
                return "4";
            case "five":
                return "5";
            case "six":
                return "6";
            case "seven":
                return "7";
            case "eight":
                return "8";
            case "nine":
                return "9";
            default:
                return "NaN";
        }
    }
}