class Solution {
    public boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        int len = str.length();

        for(int i = 0; i < len; i++) {
            if(str.charAt(i) != str.charAt(len - i - 1)) return false;
        }

        return true;
    }
}