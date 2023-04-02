import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        ArrayList<String> str1List = new ArrayList<>();
        ArrayList<String> str2List = new ArrayList<>();
        
        for(int i = 0; i < str1.length() - 1; i++) {
            if((str1.charAt(i) >= 'A' && str1.charAt(i) <= 'Z') && 
               (str1.charAt(i + 1) >= 'A' && str1.charAt(i + 1) <= 'Z')) {
                str1List.add(str1.charAt(i) + "" + str1.charAt(i + 1));
            }
        }
        
        for(int i = 0; i < str2.length() - 1; i++) {
            if((str2.charAt(i) >= 'A' && str2.charAt(i) <= 'Z') && 
               (str2.charAt(i + 1) >= 'A' && str2.charAt(i + 1) <= 'Z')) {
                str2List.add(str2.charAt(i) + "" + str2.charAt(i + 1));
            }
        }
        
        Collections.sort(str1List);
        Collections.sort(str2List);
        
        ArrayList<String> kyoList = new ArrayList<>();
        
        for(String s : str1List) {
            if(str2List.remove(s)) kyoList.add(s);
        }
        
        double kyo = kyoList.size();
        double hab = str1List.size() + str2List.size();
        if(kyo != 0 && hab != 0) answer = (int)(65536 * (kyo / hab));
        else if(kyo == 0 && hab != 0) answer = 0;
        else answer = 65536;
        
        return answer;
    }
}