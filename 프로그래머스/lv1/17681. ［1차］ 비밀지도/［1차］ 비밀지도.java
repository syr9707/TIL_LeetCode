import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) throws IOException {
        String[] answer = {};
        answer = new String[n];
        
//         int[][] b = new int[n][n];
//         String[][] c = new String[n][n];
//         for(int i = 0; i < n; i++) {
//             int num = arr1[i];
//             int num2 = arr2[i];
//             for(int j = n - 1; j >= 0; j--) {
//                 b[i][j] = num % 2;
//                 num = num / 2;
                
//                 if(num2 % 2 == 1 && b[i][j] == 0) {
//                     b[i][j] = 1;
//                 }
//                 num2 = num2 / 2;
                
//                 if(b[i][j] == 0) c[i][j] = " ";
//                 else c[i][j] = "#";
//             }
//         }
        
//         for(int i = 0; i < n; i++) {
//         	answer[i] = c[i][0];
//             for(int j = 1; j < n; j++) {
//                 answer[i] += c[i][j];
//             }
//         }
        
        // 비트연산
        for(int i = 0; i < n; i++) {
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
            answer[i] = answer[i].replaceAll("1", "#");
            answer[i] = answer[i].replaceAll("0", " ");
            
            while(answer[i].length() < n) {
                answer[i] = " " + answer[i];
            }
        }
        
        return answer;
    }
}