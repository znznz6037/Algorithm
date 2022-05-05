import java.util.*;

class Solution {
    public class FailRatio implements Comparable<FailRatio>{
        int stage;
        double ratio;

        public FailRatio(int stage, double ratio) {
            this.stage = stage;
            this.ratio = ratio;
        }

        public int compareTo(FailRatio failRatio) {

            if(this.ratio > failRatio.ratio) return -1;
            else if(this.ratio == failRatio.ratio) {
                if(this.stage > failRatio.stage) return 1;
                else return -1;
            }
            else return 1;
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        FailRatio[] userRatio = new FailRatio[N];

        for(int step = 1; step <= N; step++) {
            double users = 0;
            double fail = 0;

            for(int i = 0; i < stages.length; i++) {
                if(stages[i] >= step) {
                    users++;
                    if(stages[i] == step) fail++;
                }
            }

            if(users == 0) userRatio[step - 1] = new FailRatio(step, 0);
            else userRatio[step - 1] = new FailRatio(step, fail/users);
        }

        Arrays.sort(userRatio);

        for(int i = 0; i < N; i++) {
            System.out.print(userRatio[i].ratio + " ");
            answer[i] = userRatio[i].stage;
        }

        return answer;
    }
}