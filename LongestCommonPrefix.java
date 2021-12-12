class Solution {
    public String longestCommonPrefix(String[] strs) {
        String answer = "";
        int longestLength = 0;

        if(strs.length == 1) return strs[0];
        else {
            for(int i = 1; i <= strs[0].length(); i++) {
                int len = 0;
                String string = strs[0].substring(0, i);

                for(int j = 1; j < strs.length; j++) {
                    len = commonPrefix(string, strs[j]).length();
                    if(len == 0) break;
                }

                if(len != 0 && longestLength <= len) {
                    answer = string;
                    longestLength = len;
                }
            }
        }

        return answer;
    }

    public String commonPrefix(String str1, String str2) {
        String commonStr = "";

        for(int i = 0; i < str1.length(); i++) {
            if(str2.length() <= i) return "";

            if(str1.charAt(i) == str2.charAt(i)) commonStr += str1.charAt(i);
            else return "";
        }

        return commonStr;
    }
}