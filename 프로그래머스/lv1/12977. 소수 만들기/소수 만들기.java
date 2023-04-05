import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    int sum = 0;
                    boolean check = false;
                    sum = nums[i] + nums[j] + nums[k];
                    for(int l = 2; l <= sum / 2; l++) {
                        if(sum % l == 0) {
                            check = true;
                            break;
                        }
                    }
                    if(check == false) answer++;
                }
            }
        }

        return answer;
    }
}