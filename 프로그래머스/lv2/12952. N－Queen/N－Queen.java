import java.util.*;

class Solution {
    
    static int[] board;
    static int count=0;
    
    public int solution(int n) {
        board= new int[n];
        backTracking(n,0);
        
        return count;
    }
    
    public void backTracking(int n,int row){
        
        if(row==n){
            count++;
            return;
        }
        
        for(int i=0;i<n;i++){
            board[row]=i;          
            if(possible(row)){
                backTracking(n,row+1);
            }
        }        
    
    }
    
    public boolean possible(int row){
        
        for(int i=0;i<row;i++){
             //가로가 같을때
            if(board[i]==board[row]){
                return false;
            }           
            //대각선 (기울기)가 같을때
            if(Math.abs(row-i)==Math.abs(board[row]-board[i])){
                return false;
            }
        }
        return true;
    }
}