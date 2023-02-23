import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int min = 0;
        for(int i = people.length - 1; min <= i; i--) {
            if(people[min] + people[i] <= limit) {
                answer++;
                min++;
            }
            else answer++;
        }
        
        return answer;
    }
}