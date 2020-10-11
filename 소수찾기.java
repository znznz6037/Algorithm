class Solution {
    public int solution(String numbers) {
        int answer = 0;
        int size = (int)Math.pow(10, numbers.length());
        int num[] = new int[10];
        for(int i = 0; i < numbers.length(); i++) num[(int)numbers.charAt(i) - 48] += 1;
        for(int i = 2; i < size; i++){
            String s = Integer.toString(i);
            boolean n = true;
            int check[] = num.clone();
            for(int j = 0; j < s.length(); j++){
                if(numbers.contains(Character.toString(s.charAt(j)))){
                    if(check[(int)s.charAt(j) - 48] == 0) {
                        n = false;
                        break;
                    }
                    check[(int)s.charAt(j) - 48] -= 1;
                    continue;    
                } 
                n = false;
                break;               
            }
            if(n) if(isPrime(i)) answer++;
        }
        return answer;
    }
    
    public boolean isPrime(int n){
        for(int i = 2; i <= n / 2; i++)
            if(n % i == 0) return false;
        return true;
    }
}