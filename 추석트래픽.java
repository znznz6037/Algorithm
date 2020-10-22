import java.util.*;
import java.text.*;
 
class Solution {
    private class Process {
        String date;
        float start;
        float end;

        public Process(String date, float start, float end) {
            this.date = date;
            this.start = start;
            this.end = end;
        }
    }
    
    public int solution(String[] lines) {
        int answer = 0;

        ArrayList<Process> list = new ArrayList<>();

        for (String line : lines) {

            line = line.replace("s","");//처리 속도를 전부 숫자형태로 바꿔주기 위한 사전 처리
            String[] str = line.split(" ");//공백을 기준으로 문자열을 나눠 놓는다.
            String date = str[0];
            String[] time = str[1].split(":");//끝난 시간을 다시 :를 기준으로 나눈다.
            float end = (Float.parseFloat(time[0])*3600) + (Float.parseFloat(time[1])*60) + Float.parseFloat(time[2]); //끝난 시간을 실수 형태로 바꿔준다.

            float start = (end - Float.parseFloat(str[2])) + (float)0.001;
            list.add(new Process(date,start,end));//리스트에 담아준다.
        }

        Collections.sort(list, new Comparator<Process>() {//끝난 시간-시작 시간을 기준으로 정렬해준다.
            @Override
            public int compare(Process p1, Process p2) {
                if (p1.end == p2.end) {
                    if (p1.start < p2.start) return -1;
                    else return 1;
                } 
                else if (p1.end > p2.end) return 1;
                else return -1;
            }
        });

        for (int i = 0; i < list.size(); i++) {
            Process cur = list.get(i);
            float range = cur.end+(float)0.999;//끝난 시간을 기준으로 1초 뒤의 시간을 구해준다.
            int cnt = 0;
            for (int j = i; j < list.size(); j++) {
                Process next = list.get(j);
                if (range >= next.start) cnt++;//range 보다 현재 비교하려는 로그의 시작 시간이 작을 경우
            }
            answer = Math.max(cnt,answer);
        }
        return answer;
    }
}