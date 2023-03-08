import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
		int[] ret = new int[numbers.length];
		
		for(int i=0 ; i<numbers.length ; i++) {
        	// 하강 직선일 때는 push
			if(stack.isEmpty() || numbers[i]<numbers[i-1]) {
				stack.push(i);
			} else {
            	// 현재값보다 작은 index는 pop하여 현재값으로
				while(!stack.isEmpty() && numbers[stack.peek()]<numbers[i]) {
					ret[stack.pop()] = numbers[i];
				}
				stack.push(i);
			}
		}
        // 나머지는 -1
		while(!stack.isEmpty()) {
			ret[stack.pop()] = -1;
		}
        
		return ret;
    }
}