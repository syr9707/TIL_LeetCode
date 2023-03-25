import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) throws IOException {
        String answer = s;
        
        String[] a = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] b = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        
        for(int i = 0; i < 10; i++) {
            answer = answer.replaceAll(a[i], b[i]);
        }
        
        int Ianswer = Integer.parseInt(answer);
        
        return Ianswer;
    }
}