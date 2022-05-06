class Solution {
    private static final int DEFAULT_VALUE = 1;

    public String removeDuplicates(String s, int k) {

        String answer = "";

        List<Integer> stack = new ArrayList<>();
        for(int i = 0; i<s.length(); i++) {
            char curCharacter = s.charAt(i);
            if(answer.isEmpty()) {
                answer += curCharacter;
                stack.add(DEFAULT_VALUE);
                continue;
            }

            int stackTopIndex = stack.size()-1;
            char strTop = answer.charAt(answer.length()-1);
            int stackTop = stack.get(stackTopIndex);
            if(strTop == s.charAt(i)) {
                if(stackTop+1 == k) {
                    answer = answer.substring(0, answer.length()-stackTop);
                    stack.remove(stackTopIndex);
                } else {
                    answer += curCharacter;
                    stack.set(stackTopIndex, stackTop+1);
                }
                continue;
            }

            answer+=curCharacter;
            stack.add(DEFAULT_VALUE);
        }

        return answer;
    }
}