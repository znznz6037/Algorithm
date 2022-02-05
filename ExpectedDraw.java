class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;

        // 어차피 a와 b는 항상 이기므로, 2로 계속 나눠서
        // | a - b | = 1  && a / 2 != b / 2 이면 해 도출
        // 2 3 인 경우 -> | a - b | = 1 이지만, a는 1번과 붙고, b는 4번과 붙어
        // 2라운드에 만나기 때문에 a / 2 != b / 2 조건도 충족되어야 함

        while(Math.abs(a - b) != 1 || (a / 2 == b / 2)) {
            if(a % 2 != 0) a++;
            if(b % 2 != 0) b++;

            a /= 2;
            b /= 2;

            answer++;
        }

        return answer;
    }
}