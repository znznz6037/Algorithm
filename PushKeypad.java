class Solution {
    int[][] handIdx = {
            {3, 0},
            {3, 2}
    };

    public String solution(int[] numbers, String hand) {
        String answer = "";

        for(int i = 0; i < numbers.length; i++) {
            answer += determineFinger(numbers[i], handIdx, hand);
        }

        return answer;
    }

    public char determineFinger(int number, int[][] handIdx, String hand) {
        if(number == 1 || number == 4 || number == 7) {
            moveFinger(number, handIdx, "left");
            return 'L';
        }
        else if(number == 3 || number == 6 || number == 9) {
            moveFinger(number, handIdx, "right");
            return 'R';
        }
        else {
            return nearestHand(number, handIdx, hand);
        }
    }

    public char nearestHand(int number, int[][] handIdx, String hand) {
        if(number == 0) number = 11;

        int targetIdx[] = {(number - 1) / 3, (number - 1) % 3};
        int leftDist = Math.abs(targetIdx[0] - handIdx[0][0]) + Math.abs(targetIdx[1] - handIdx[0][1]);
        int rightDist = Math.abs(targetIdx[0] - handIdx[1][0]) + Math.abs(targetIdx[1] - handIdx[1][1]);

        if(leftDist > rightDist) {
            moveFinger(number, handIdx, "right");
            return 'R';
        }
        else if(leftDist < rightDist) {
            moveFinger(number, handIdx, "left");
            return 'L';
        }
        else {
            if(hand.equals("left")) {
                moveFinger(number, handIdx, "left");
                return 'L';
            }
            else {
                moveFinger(number, handIdx, "right");
                return 'R';
            }
        }
    }

    public void moveFinger(int number, int[][] handIdx, String hand) {
        if(hand.equals("left")) {
            handIdx[0][0] = (number - 1) / 3;
            handIdx[0][1] = (number - 1) % 3;
        }
        else {
            handIdx[1][0] = (number - 1) / 3;
            handIdx[1][1] = (number - 1) % 3;
        }
    }
}