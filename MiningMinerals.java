class Solution {
    static int min = Integer.MAX_VALUE;
    
    public int solution(int[] picks, String[] minerals) {
        dfs(picks, minerals, 0, 0);
        return min;
    }
    
    public void dfs(int[] picks, String[] minerals, int idx, int cost) {
        if(idx == minerals.length ||
            (picks[0] + picks[1] + picks[2]) == 0) {
            min = Math.min(cost, min);
            return;
        }
        
        int len = idx + 5;
        if(len > minerals.length) len = minerals.length;
        
        for(int i = 0; i < 3; i++) {
            if(picks[i] == 0) continue;
            
            int sum = 0;
            for(int j = idx; j < len; j++) {
                sum += fatigue(i, minerals[j]);
            }
            
            --picks[i];
            dfs(picks, minerals, len, cost + sum);
            ++picks[i];
        }
    }
    
    public int fatigue(int pick, String mineral) {
        switch(mineral) {
            case "diamond":
                if(pick == 0) return 1;
                if(pick == 1) return 5;
                if(pick == 2) return 25;
            
            case "iron":
                if(pick == 2) return 5;
                return 1;
                
            default:
                return 1;
        }
    }
}
