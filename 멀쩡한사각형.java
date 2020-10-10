class Solution {
    static double gradient, width, height;
    public long solution(int w, int h) {
        width = (double)w;
        height = (double)h;
        gradient = height / (-width);
        long answer = 0;
        for(int i = 1; i < w; i++) {
            long cnt = equation(i);
            answer += cnt;
        }
        return answer * 2;      
    }

    public static long equation(int x) {
        long y = (long)(gradient * x + height);
        return y;
    }
}