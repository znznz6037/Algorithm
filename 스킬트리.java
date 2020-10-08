import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Queue<Character> q = new LinkedList<Character>();
        for(int i = 0; i < skill_trees.length; i++) {
            q.clear();
            for(int j = 0; j < skill.length(); j++) {
                q.add(skill.charAt(j));
            }
            int result = 1;
            for(int j = 0; j < skill_trees[i].length(); j++) {
                if(!q.isEmpty()) {
                    if(q.peek().equals(skill_trees[i].charAt(j))) q.poll();
                    if(q.contains(skill_trees[i].charAt(j))) {
                        result = 0;
                        break;
                    }
                }
            }
            if(result != 0) answer++;
        }
        return answer;
    }
}