class Solution {
    public String addBinary(String a, String b) {
        int diff = 0;
        if(a.length() > b.length()) {
            diff = a.length() - b.length();
            while(diff-- > 0) b = '0' + b;
        }
        else if(a.length() < b.length()) {
            diff = b.length() - a.length();
            while(diff-- > 0) a = '0' + a;
        }

        int increase = 0;
        String solution = "";
        for(int i = a.length() - 1; i >= 0; i--) {
            int result = (a.charAt(i) - '0') + (b.charAt(i) - '0') + increase;
            if(result == 3) {
                solution = '1' + solution;
                increase = 1;
            }
            else if(result == 2) {
                solution = '0' + solution;
                increase = 1;
            }
            else {
                solution = result + solution;
                increase = 0;
            }
        }
        if(increase == 1) solution = '1' + solution;

        return solution;
    }
}