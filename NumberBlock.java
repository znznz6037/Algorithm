class Solution {
    public int[] solution(long begin, long end) {
        return getBlocks(begin, end);
    }

    public int[] getBlocks(long begin, long end) {
        int len = (int)(end - begin) + 1;
        int[] blocks = new int[len];
        for(int i = 0; i < len; i++) {
            blocks[i] = (int)getNum(begin + i);
        }

        return blocks;
    }

    public long getNum(long num) {
        if(num == 1) return 0;
        if(num % 10000000 == 0) return 10000000;
        for(long i = Math.max(2, num / 10000000); i * i <= num; i++) {
            if(num % i == 0 && num / i < 10000000) return num / i;
        }
        return 1;
    }
}