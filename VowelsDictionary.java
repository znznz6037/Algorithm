class Solution {
    static final String vowels = "AEIOU";
    static final int[] weight = {781, 156, 31, 6, 1};

    public int solution(String word) {
        return getOrderofWord(word);
    }

    public int getOrderofWord(String word) {
        int len = word.length();
        int order = len;

        for(int i = 0; i < len; i++) {
            order += weight[i] * (vowels.indexOf(word.charAt(i)));
        }

        return order;
    }
}