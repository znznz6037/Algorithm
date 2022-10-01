import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PhoneNumberList {
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        answer = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] phoneNumber = new String[n];
            Map<String, Integer> map = new HashMap<>();

            for(int j = 0; j < n; j++) {
                phoneNumber[j] = br.readLine();
                map.put(phoneNumber[j], 0);
            }

            isConsistentList(phoneNumber, map);
        }

        br.close();

        System.out.print(answer.toString());
    }

    public static void isConsistentList(String[] phoneNumber, Map<String, Integer> map) {
        for(int i = 0; i < phoneNumber.length; i++) {
            for(int l = 1; l <= phoneNumber[i].length(); l++) {
                String subStr = phoneNumber[i].substring(0, l);
                if (map.containsKey(subStr)) {
                    map.put(phoneNumber[i], map.get(phoneNumber[i]) + 1);
                    if(map.get(phoneNumber[i]) > 1) {
                        answer.append("NO\n");
                        return;
                    }
                }
            }

            map.put(phoneNumber[i], 1);
        }

        answer.append("YES\n");
    }
}