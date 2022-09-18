class Solution {
    final int maxLength = 3600000;
    int[] playCount;
    int advTime;
    int playTime;

    public String solution(String play_time, String adv_time, String[] logs) {
        if(play_time.equals(adv_time)) return "00:00:00";

        advTime = getSeconds(adv_time);
        playTime = getSeconds(play_time);
        playCount = new int[maxLength];

        for(String log: logs) {
            String[] splittedLog = log.split("-");

            int startTime = getSeconds(splittedLog[0]);
            playCount[startTime] += 1;

            int endTime = getSeconds(splittedLog[1]);
            playCount[endTime] -= 1;
        }

        for(int i = 0; i < maxLength - 1; i++) {
            playCount[i + 1] += playCount[i];
        }

        long sum = 0;
        long maxSum = 0;
        int answerSeconds = 0;

        for(int i = 0; i < advTime; i++) {
            sum += playCount[i];
        }
        maxSum = sum;

        for(int i = advTime; i < playTime; i++) {
            sum += playCount[i] - playCount[i - advTime];  //핵심!!!
            if(sum > maxSum) {
                maxSum = sum;
                answerSeconds = i - advTime + 1;
            }
        }

        return secondsToStringTime(answerSeconds);
    }

    public int getSeconds(String time) {
        String[] splittedTime = time.split(":");

        int h = Integer.parseInt(splittedTime[0]) * 3600;
        int m = Integer.parseInt(splittedTime[1]) * 60;
        int s = Integer.parseInt(splittedTime[2]);

        return h + m + s;
    }

    public String secondsToStringTime(int seconds) {
        int h = seconds / 3600;
        int m = (seconds % 3600) / 60;
        int s = seconds % 3600 % 60;

        String time = "";
        if(h < 10) time += "0" + h + ":";
        else time += h + ":";

        if(m < 10) time += "0" + m + ":";
        else time += m + ":";

        if(s < 10) time += "0" + s;
        else time += s + "";

        return time;
    }
}