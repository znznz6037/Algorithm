import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0, curIdx = 0;
		StringBuilder str = new StringBuilder();
	    for(int i = 0; i < name.length(); i++) str.append('A');
	    while(!(str.toString()).equals(name)){
	        int[] minDist = new int[name.length()];
	        Arrays.fill(minDist, -1);
	        
	        for(int i = 0; i < name.length(); i++){ // 바꿔야할 문자까지의 최소 거리 배열
	            if(str.charAt(i) != name.charAt(i)){
	            	if(i == curIdx) minDist[i] = 0;
	            	else {
		            	int a = Math.abs(curIdx - i);
		            	int b = Math.abs(curIdx - i + name.length());
		                minDist[i] = a > b ? b : a; //문자가 다른 곳 까지의 거리
	            	}
	            }    
	        }
	        
	        int min = 100;
	        for(int i = 0; i < name.length(); i++){ // 최소 조이스틱 조작
	            if(minDist[i] >= 0){
	                if(min > minDist[i]){
	                    min = minDist[i];
	                    curIdx = i;
	                }
	            }
	        }
	        
	        for(int i = 0; i < name.length(); i++){ // 최소 조이스틱 구하기
	            if(i == curIdx){
	                int a = Math.abs((str.charAt(i) - 'A') - (name.charAt(i) - 'A'));
	                int b = Math.abs((str.charAt(i) - 'A') - (name.charAt(i) - 'A') + 26);
	                //System.out.println(a + " " + b);
	                minDist[i] += a > b ? b : a;	              
	            }
	        }
	        /* 각 지점 거리 + 조이스틱 조작 중 최소를 선택하는 줄 알았음
	        for(int i = 0; i < name.length(); i++){ // 최소 조이스틱 구하기
	            if(minDist[i] >= 0){
	                int a = Math.abs((str.charAt(i) - 'A') - (name.charAt(i) - 'A'));
	                int b = Math.abs((str.charAt(i) - 'A') - (name.charAt(i) - 'A') + 26);
	                //System.out.println(a + " " + b);
	                minDist[i] += a > b ? b : a;	              
	            }
	        }
	   
	        // 1 2 3 4 5 6
	        min = 100;
	        for(int i = 0; i < name.length(); i++){ // 최소 조이스틱 조작
	            if(minDist[i] >= 0){
	                if(min > minDist[i]){
	                    min = minDist[i];
	                    curIdx = i;
	                    //System.out.println(minDist[i]);
	                }
	            }
	        }
	        */
	        str.setCharAt(curIdx, name.charAt(curIdx));
	        answer += minDist[curIdx];
	    }
	    return answer;
    }
}