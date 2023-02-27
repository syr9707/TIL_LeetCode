import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int len = elements.length;
        int[] arr = new int[len * 2];
        
        for(int i = 0; i < len; i++) {
            arr[i] = arr[i + len] = elements[i];
        }
        
        HashSet<Integer> set = new HashSet<>();
        for(int i = 1; i <= len; i++) {
            for(int j = 0; j < len; j++) {
                set.add(Arrays.stream(arr, j, j + i).sum());
            }
        }
        
        answer = set.size();
        
        return answer;
    }
}