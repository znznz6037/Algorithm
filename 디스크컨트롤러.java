import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                return arr1[0] - arr2[0];
            }
        });
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                return arr1[1] - arr2[1];
            }
        });
        int idx = 0, end = 0, cnt = 0;
        while(cnt < jobs.length){
            while(idx < jobs.length && jobs[idx][0] <= end){
                heap.add(jobs[idx++]);
            }
            if(heap.isEmpty()) end = jobs[idx][0];
            else{
                int[] task = heap.poll();
                answer += end + task[1] - task[0];
                end += task[1];
                cnt++;
            }
        }
    
        return (int)(answer / jobs.length);
    }
}