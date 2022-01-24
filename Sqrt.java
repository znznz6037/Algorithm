class Solution {
    public int mySqrt(int x) {
        if(x < 2) return x;

        int left = 1, right = Integer.MAX_VALUE;
        while(true) {
            int mid = left + (right - left) / 2;
            if(mid > x / mid) {
                right = mid - 1;
            }
            else {
                if(mid + 1 > x / (mid + 1)) return mid;
                //if((mid + 1) * (mid + 1) > x) return mid 하면 시간초과 나는 이유..?
                left  = mid + 1;
            }
        }
    }
}