import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = nums.length / 2;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int n : nums) {
            set.add(n);
        }
        
        if(set.size() > answer) return answer;
        else return set.size();
        
    }
}