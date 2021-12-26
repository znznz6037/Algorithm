class Solution {
    public int[] plusOne(int[] digits) {
        int len = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] == 9) {
                digits[i] = 0;
                len++;
            }
            else {
                digits[i]++;
                break;
            }
        }

        if(len > digits.length) {
            int[] result = new int[len];
            result[0] = 1;
            return result;
        }
        return digits;
    }
}