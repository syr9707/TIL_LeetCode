import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] routes) {
        
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        int location = routes[0][1];
        int answer = 1;
        
        for(int i = 1; i < routes.length; i++) {
            if(routes[i][0] > location) {
                answer++;
                location = routes[i][1];
            }
        }
        
        return answer;
    }
}