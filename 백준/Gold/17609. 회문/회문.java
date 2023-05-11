import java.util.*;
import java.io.*;

public class Main {
 
    static int t;
    static String s;
    
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t= Integer.parseInt(br.readLine());
        
        for(int i=0; i<t; i++){
            s = br.readLine();
 
            if(check(0, s.length()-1)){
                System.out.println(0);
            } else{
                if(ReCheck(0,s.length()-1)){
                    System.out.println(1);
                } else{
                    System.out.println(2);
                }
            }
        }
    }
 
    public static boolean check(int left, int right){
 
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
 
    public static boolean ReCheck(int left, int right){
 
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)){
               boolean a = check(left+1,right);
               boolean b = check(left, right-1);
               if(!a && !b)return false; 
               else return true;
            }
            left++;
            right--;
        }
        
        return true;
    }
}