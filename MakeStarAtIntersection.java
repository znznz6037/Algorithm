import java.util.*;

class Solution {
    private class Coord {
        private long y;
        private long x;
        private boolean isParallel;

        public Coord(long y, long x, boolean isParallel) {
            this.y = y;
            this.x = x;
            this.isParallel = isParallel;
        }
    }

    private long maxY = Long.MIN_VALUE;
    private long minY = Long.MAX_VALUE;
    private long maxX = Long.MIN_VALUE;
    private long minX = Long.MAX_VALUE;

    public String[] solution(int[][] line) {
        String[] answer = {};
        ArrayList<Coord> coordList = new ArrayList<>();

        for(int i = 0; i < line.length - 1; i++) {
            for(int j = i + 1; j < line.length; j++) {
                Coord coord = getIntersection(line[i], line[j]);

                if(!coord.isParallel) {
                    coordList.add(new Coord(coord.y, coord.x, false));
                }
            }
        }

        int yLen = (int)Math.abs(maxY - minY) + 1;
        int xLen = (int)Math.abs(maxX - minX) + 1;
        char[][] map = new char[yLen][xLen];
        answer = new String[yLen];

        for(Coord coord: coordList) {
            map[(int)(coord.y - minY)][(int)(coord.x - minX)] = '*';
        }

        for(int i = yLen - 1; i >=  0; i--) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < xLen; j++) {
                if(map[i][j] == '*') sb.append("*");
                else sb.append(".");
            }
            answer[yLen - i - 1] = sb.toString();
        }

        return answer;
    }

    public Coord getIntersection(int[] line1, int[] line2) {
        long a = line1[0];
        long b = line1[1];
        long e = line1[2];
        long c = line2[0];
        long d = line2[1];
        long f = line2[2];
        double denominator = a * d - b * c;

        if(denominator == 0) return new Coord(0, 0, true);

        double dy = (e * c - a * f) / denominator;
        double dx = (b * f - e * d) / denominator;

        if(Math.ceil(dy) != dy || Math.ceil(dx) != dx) return new Coord(0, 0, true);

        if(maxY <= dy) maxY = (long)dy;
        if(minY >= dy) minY = (long)dy;
        if(maxX <= dx) maxX = (long)dx;
        if(minX >= dx) minX = (long)dx;

        return new Coord((long)dy, (long)dx, false);
    }
}