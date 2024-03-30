import java.util.*;

class Solution {
    
    class Plan {
        String name;
        int start;
        int playtime;
        
        Plan(String name, String start, String playtime) {
            String[] strArr = start.split(":");
            
            this.name = name;
            this.start = Integer.parseInt(strArr[0]) * 60 + Integer.parseInt(strArr[1]);
            this.playtime = Integer.parseInt(playtime);
        };
    }
    
    public String[] solution(String[][] plans) {
        PriorityQueue<Plan> list = new PriorityQueue<>((a, b) -> Integer.compare(a.start, b.start));
        Stack<Plan> stack = new Stack<>();
        
        int index = 0;
        int curTime = 0;
        String[] answer = new String[plans.length];
        
        for (String[] plan : plans) {
            list.add(new Plan(plan[0], plan[1], plan[2]));
        }    
        
        while(!list.isEmpty() || !stack.isEmpty()) {
             if (list.isEmpty()) {
                answer[index++] = stack.pop().name;

            } else if (stack.isEmpty()) {
                curTime = list.peek().start;
                stack.push(list.poll());

            } else {
                if (list.peek().start < curTime + stack.peek().playtime) {
                    //새 작업 시작전에 진행중인 작업 완료 불가 : 진행중작업 잔여시간 갱신, 새 작업 시작

                    stack.peek().playtime -= list.peek().start - curTime;
                    curTime = list.peek().start;
                    stack.push(list.poll());

                } else {
                    //새 작업 시작전에 진행중인 작업 완료 : 진행중 작업 완료 및 현재시간 갱신
                    curTime += stack.peek().playtime;
                    answer[index++] = stack.pop().name;

                }
            }
        }
        
        return answer;
    }
}
