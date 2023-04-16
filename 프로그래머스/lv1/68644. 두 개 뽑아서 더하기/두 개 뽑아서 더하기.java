import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < numbers.length; i++) {
            int sum = 0;
            
            for(int j = i + 1; j < numbers.length; j++) {
                sum = numbers[i] + numbers[j];
                if(!list.contains(sum)) list.add(sum);
            }
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        
        return answer;
    }
}