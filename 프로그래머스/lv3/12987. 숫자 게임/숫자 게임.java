import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int idx = A.length - 1;
        for(int i = A.length - 1; i >= 0; i--) {
            if(A[i] < B[idx]) {
                answer++;
                idx--;
            }
        }
        
        return answer;
    }
}