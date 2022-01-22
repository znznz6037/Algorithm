import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        //행렬 생성
        int[][] matrix = new int[rows][columns];
        int num = 1;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                matrix[i][j] = num++;
            }
        }

        // 회전
        for(int i = 0; i < queries.length; i++) {
            int minX = queries[i][0] - 1, minY = queries[i][1] - 1;
            int maxX = queries[i][2] - 1, maxY = queries[i][3] - 1;
            int colLen = maxY - minY;
            int rowLen = maxX - minX;

            int[][] copied = new int[rows][columns];
            for(int a = 0; a < rows; a++) {
                for(int b = 0; b < columns; b++) {
                    copied[a][b] = matrix[a][b];
                }
            }

            int min = 100;
            ArrayList<Integer> arrayList = new ArrayList<>();

            //1. x축 오른쪽 rowLen
            for(int a = 1; a <= colLen; a++) {
                matrix[minX][minY + a] = copied[minX][minY + a - 1];
                arrayList.add(matrix[minX][minY + a]);
            }
            //2. y축 아래쪽 colLen
            for(int a = 1; a <= rowLen; a++) {
                matrix[minX + a][maxY] = copied[minX + a - 1][maxY];
                arrayList.add(matrix[minX + a][maxY]);
            }
            //3. x축 왼쪽 rowLen
            for(int a = 1; a <= colLen; a++) {
                matrix[maxX][maxY - a] = copied[maxX][maxY - a + 1];
                arrayList.add(matrix[maxX][maxY - a]);
            }
            //4. y축 위쪽 colLen
            for(int a = 1; a <= rowLen; a++) {
                matrix[maxX - a][minY] = copied[maxX - a + 1][minY];
                arrayList.add(matrix[maxX - a][minY]);
            }

            Collections.sort(arrayList);
            answer[i] = arrayList.get(0);
        }
        return answer;
    }
}