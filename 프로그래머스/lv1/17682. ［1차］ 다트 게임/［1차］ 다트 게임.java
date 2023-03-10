class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int[] num = new int[3];
        
        int n = 0;
        int idx = 0;
        String str = "";
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(c >= '0' && c <= '9') {
                str += String.valueOf(c);
            }
            else if(c == 'S' || c == 'D' || c == 'T') {
                n = Integer.parseInt(str);
                if(c == 'S') num[idx++] = (int)Math.pow(n, 1);
                else if(c == 'D') num[idx++] = (int)Math.pow(n, 2);
                else num[idx++] = (int)Math.pow(n, 3);
                str = "";
            }
            else {
                if(c == '*') {
                    num[idx - 1] = num[idx - 1] * 2;
                    if((idx - 1) - 1 >= 0) num[idx - 2] = num[idx - 2] * 2;
                }
                else num[idx - 1] = num[idx - 1] * (-1);
            }
        }
        
        answer = num[0] + num[1] + num[2];
        return answer;
    }
}