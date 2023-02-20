import java.util.*;

class Solution {
    
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        
        for(int i = 0; i < len; i++) {
            Stack<Character> stack = new Stack<>();
            String str = s.substring(i, len) + s.substring(0, i);
            
            for(int j = 0; j < len; j++) {
                char c = str.charAt(j);
                
                if(c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                    continue;
                }
                
                if(stack.size() == 0) break;
                
                char cc = stack.peek();
                
                if(c == ')') {
                    if(cc != '(') break;
                    else stack.pop();
                } else if(c == '}') {
                    if(cc != '{') break;
                    else stack.pop();
                } else if(c == ']') {
                    if(cc != '[') break;
                    else stack.pop();
                }
                
                if(j == len - 1 && stack.size() == 0) answer++;
            }
        }
        
        return answer;
    }
}