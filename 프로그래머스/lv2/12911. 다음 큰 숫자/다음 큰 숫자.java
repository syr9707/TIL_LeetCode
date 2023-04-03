class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // String str = Integer.toBinaryString(n);
        // System.out.println(str);
        
        int bitCount = Integer.bitCount(n);
        //System.out.println(bitCount);
        for(int i = n + 1; ; i++) {
            if(Integer.bitCount(i) == bitCount) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}