import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);

        Integer[] bInt = new Integer[B.length];
        for(int i = 0; i < B.length; i++) bInt[i] = Integer.valueOf(B[i]);
        Arrays.sort(bInt, Collections.reverseOrder());

        for(int i = 0; i < B.length; i++)
            answer += A[i] * bInt[i];

        return answer;
    }
}