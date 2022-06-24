import java.util.*;

class Solution {
    int answer = 0;

    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return cities.length * 5;

        getExecutionTime(cacheSize, cities);
        return answer;
    }

    public void getExecutionTime(int cacheSize, String[] cities) {
        String[] cache = new String[cacheSize];
        for(int i = 0; i < cacheSize; i++) {
            cache[i] = " ";
        }

        for(int i = 0; i < cities.length; i++) {
            boolean hit = false;
            for(int j = 0; j < cacheSize; j++) {
                if(cache[j].equals(cities[i].toUpperCase())) {
                    hit = true;
                    break;
                }
            }

            LRU(cache, cities[i].toUpperCase(), hit);
        }
    }

    public void LRU(String[] cache, String city, boolean hit) {
        int cacheSize = cache.length;
        String prevCity = " ";
        String currentCity = " ";

        if(hit) {
            for(int i = 0; i < cacheSize; i++) {
                currentCity = cache[i];
                cache[i] = prevCity;
                prevCity = currentCity;
                if(city.equals(currentCity)) break;
            }
            answer++;
        }
        else {
            for(int i = cacheSize - 1; i > 0; i--) {
                cache[i] = cache[i - 1];
            }
            answer += 5;
        }

        cache[0] = city;
    }
}