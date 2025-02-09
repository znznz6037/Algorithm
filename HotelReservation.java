import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] book_time_min = new int[book_time.length][2];
        for(int i = 0; i < book_time.length; i++) {
            book_time_min[i][0] = convertToMin(book_time[i][0]);
            book_time_min[i][1] = convertToMin(book_time[i][1]);
        }
        
        Arrays.sort(book_time_min, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        
        //시간이 겹치는 방이 있으면 새 방에 넣어준다.
        //시간이 안 겹치면 기존 방에 넣어준다.
        HashMap<Integer, int[]> map = new HashMap<>();
        for(int i = 0; i < book_time_min.length; i++) {
            int start = book_time_min[i][0];
            int end = book_time_min[i][1];
            
            if(map.isEmpty()) {
                map.put(1, new int[]{start, end});
                continue;
            }
            
            Iterator<Integer> keys = map.keySet().iterator();
            boolean isAdded = false;
            while(keys.hasNext()){
                int key = keys.next();
                int[] value = map.get(key);
                
                //사용이 완료된 방은 새로운 시간으로 갱신
                if(start >= value[1] + 10) {
                    map.put(key, new int[]{start, end});
                    isAdded = true;
                    break;
                }
            }
            
            //사용이 완료된 방이 없었다면 새 방으로 넣어준다
            if(!isAdded) {
                map.put(map.size() + 1, new int[]{start, end});
            }
        }
        
        return map.size();
    }
    
    public int convertToMin(String time) {
        String[] arr = time.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}
