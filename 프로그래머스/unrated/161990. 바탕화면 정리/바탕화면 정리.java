import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        int minCol = Integer.MAX_VALUE;
        int minRow = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;
        int maxRow = Integer.MIN_VALUE;
        
        for(int i = 0; i < wallpaper.length; i++) {
            for(int j = 0; j < wallpaper[i].length(); j++) {
                char c = wallpaper[i].charAt(j);
                if(c == '#') {
                    if(i < minRow) minRow = i;
                    if(i > maxRow) maxRow = i;
                    if(j < minCol) minCol = j;
                    if(j > maxCol) maxCol = j;
                }
            }
        }
        
        answer[0] = minRow;
        answer[1] = minCol;
        answer[2] = maxRow + 1;
        answer[3] = maxCol + 1;
        
        return answer;
    }
}