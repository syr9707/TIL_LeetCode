import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return cities.length * 5;
        
        int answer = 0;
        
        LinkedList<String> cache = new LinkedList<>();
        for(int i = 0; i < cities.length; i++) {
            String s = cities[i].toUpperCase();
            
            if(cache.remove(s)) { // 해당 값이 없으면 false, 있다면 지우고 true 반환
                answer += 1;
                cache.add(s);
            }
            else {
                answer += 5;
                if(cache.size() >= cacheSize) cache.remove(0);
                
                cache.add(s);
            }
            // System.out.println(cache +  " " + answer);
        }
        
        return answer;
    }
}