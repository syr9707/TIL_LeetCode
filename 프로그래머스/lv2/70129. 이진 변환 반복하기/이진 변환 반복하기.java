class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') count++;
        }
        answer[1] += s.length() - count;
        answer[0]++;
        s = "1";
        for(int i = 1; i < count; i++) s += "1";
        System.out.println(s);
        
        while(true) {
            if(s.equals("1")) break;
            int countZero = 0;
            int countTotal = 0;
            int num = count;
            while(num != 0) {
                if(num % 2 == 0) countZero++;
                num = num / 2;
                countTotal++;
            }
            count = countTotal - countZero;
            answer[1] += countZero;
            answer[0]++;
            if(count == 1) break;
            s = "1";
            for(int i = 1; i < count; i++) s += "1";
            System.out.println(s);
        }
        
        return answer;
    }
}