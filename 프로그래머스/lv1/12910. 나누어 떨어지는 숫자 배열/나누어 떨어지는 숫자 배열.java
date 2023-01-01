import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        
        Arrays.sort(arr);
        
        if(divisor == 1) return arr;
        
        int k = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) k++;
        }
        
        if(k == 0) return new int[]{-1};
        
        answer = new int[k];
        
        k = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) {
                answer[k++] = arr[i];
            }
        }
        
        return answer;
    }
}