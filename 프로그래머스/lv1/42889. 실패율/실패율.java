import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int N, int[] stages) throws IOException {
        int[] answer = new int[N];
        
        int[] count = new int[N + 1];
        double[] sortAns = new double[N];
        for(int i = 0; i < stages.length; i++) {
            if(stages[i] == N + 1) continue;
            count[stages[i]]++;
        }
        
        int sum = 0;
        for(int i = 1; i <= N; i++) {
            sum += count[i - 1];
            if((stages.length - sum) == 0) {
                sortAns[i - 1] = 0;
                continue;
            }
            else {
                sortAns[i - 1] = (double)count[i] / (stages.length - sum);
            }
        }
        
        for(int i = 0; i < N; i++) {
            System.out.println(sortAns[i]);
        }
        
        double max = 0;
        int target = 1;
        for(int i = 0; i < sortAns.length; i++) {
            max = sortAns[0];
            target = 1;
            for(int j = 0; j < sortAns.length; j++) {
                if(sortAns[j] > max) {
                    max = sortAns[j];
                    target = j + 1;
                }
            }
            sortAns[target - 1] = -1;
            answer[i] = target;
        }
        
        return answer;
                              
    }
}