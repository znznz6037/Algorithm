class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int[][] map = new int[board.length + 1][board[0].length + 1];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                map[i + 1][j + 1] = board[i][j];
            }
        }
        
        for(int i = 1; i < map.length; i++){
            for(int j = 1; j < map[0].length; j++){
                if(map[i][j] == 0) continue;
                map[i][j] = Math.min(Math.min(map[i - 1][j - 1], map[i - 1][j]), map[i][j - 1]) + 1;
                answer = Math.max(answer, map[i][j]);
            }
        }
        
        return answer * answer;
    }
}