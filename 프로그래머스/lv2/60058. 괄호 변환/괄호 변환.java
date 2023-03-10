import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = dfs(p);
        
        return answer;
    }
    
    static String dfs(String str){
        int cnt=0,idx=0,len = str.length();
        String result = "";
        //1
        if(str.equals("")) return str;
        while(idx<len){
            char c = str.charAt(idx++);
            if(c=='(') cnt++;
            else cnt--;
            if(cnt==0) break;
        }
        //2
        String u = str.substring(0,idx);
        String v = str.substring(idx,len);
        
        //3
        if(isComplete(u)){
            result = u + dfs(v);
        }
        else{
            result = "("+dfs(v)+")";
            int ulen = u.length();
            for(int i=1;i<ulen-1;i++){
                char c = u.charAt(i);
                if(c=='(') result+=')';
                else result+='(';
            }
        }
        return result;
    }
    
    static boolean isComplete(String str){
        Stack<Character> s = new Stack<>();
        int len = str.length();
        
        for(int i=0;i<len;i++){
            char c = str.charAt(i);
            if(c=='(') s.add(c);
            else{
                if(s.isEmpty()) return false;
                else s.pop();
            }
        }
        return s.isEmpty();
    }
}