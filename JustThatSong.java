import java.util.*;

class Solution {
    static String[][] replaceChar = {
            {"A#", "H"},
            {"C#", "I"},
            {"D#", "J"},
            {"F#", "K"},
            {"G#", "L"}
    };

    public String solution(String m, String[] musicinfos) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> times = new ArrayList<>();

        m = replaceSharp(m);

        for(int i = 0; i < musicinfos.length; i++) {
            String[] info = musicinfos[i].split(",");
            info[3] = replaceSharp(info[3]);
            int runningTime = getRunningTime(info[0], info[1]);
            String melody = makeMelody(runningTime, info[3]);

            if(melody.contains(m)) {
                if(!times.contains(runningTime)) {
                    times.add(runningTime);
                    map.put(info[2], runningTime);
                }
            }
        }

        if(map.isEmpty()) return "(None)";

        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        answer = keys.get(0);
        return answer;
    }

    public String replaceSharp(String s) {
        for(int i = 0; i < 5; i++) {
            s = s.replace(replaceChar[i][0], replaceChar[i][1]);
        }

        return s;
    }

    public String makeMelody(int runningTime, String melody) {
        String s = "";
        int len = melody.length();
        int cnt = 0;

        for(int i = 0; i < runningTime; i++) {
            if(cnt >= len) cnt = 0;
            s += melody.charAt(cnt++);
        }

        return s;
    }

    public int getRunningTime(String start, String end) {
        String[] s = start.split(":");
        String[] e = end.split(":");

        return (Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1])) - (Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]));
    }
}