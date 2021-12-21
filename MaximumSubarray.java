class Solution {
    public int maxSubArray(int[] nums) {
        int max = -100000, cur = 0;
        for(int n: nums) {
            cur += n;
            if(max < cur) max = cur;

            if(cur < 0) cur = 0;
        }

        return max;
    }
}