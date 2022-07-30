import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        HashMap<String, List<String[]>> recordMap = new HashMap<>();

        for(int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            List<String[]> log = recordMap.get(record[1]);
            if(log == null) log = new ArrayList<String[]>();
            log.add(record);
            recordMap.put(record[1], log);
        }

        List<String> keySet = new ArrayList<>(recordMap.keySet());
        Collections.sort(keySet);

        answer = new int[recordMap.size()];

        int idx = 0;
        for(String number: keySet) answer[idx++] = countFee(fees, recordMap.get(number));

        return answer;
    }

    int getMinute(String inTime, String outTime) {
        int in = Integer.parseInt(inTime.substring(0, 2)) * 60 + Integer.parseInt(inTime.substring(3, 5));
        int out = Integer.parseInt(outTime.substring(0, 2)) * 60 + Integer.parseInt(outTime.substring(3, 5));

        return out - in;
    }

    int countFee(int[] fees, List<String[]> log) {
        int fee = 0;
        int minutes = 0;
        int len = log.size();

        for(int i = 0; i < len; i++) {
            String[] record = log.get(i);

            if(record[2].equals("OUT")) {
                String[] in = log.get(i - 1);
                minutes += getMinute(in[0], record[0]);
            }
            else if(i == len - 1 && record[2].equals("IN")) {
                minutes += getMinute(record[0], "23:59");
            }
        }

        if(minutes <= fees[0]) fee += fees[1];
        else {
            int ceil = (int)Math.ceil((double)(minutes - fees[0]) / fees[2]);
            fee += fees[1] + ceil * fees[3];
        }

        return fee;
    }
}