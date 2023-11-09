class Solution {
    
    private static final int[] SALE_PERCENT = {10,20,30,40};
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] sale = new int[emoticons.length];
        int[] answer = dfs(0,sale,users,emoticons);
        return answer;
    }
    
    private int[] dfs(int depth,int[] sale, int[][] users,int[] emoticons){
        if(depth == emoticons.length){
            return cal(sale,users,emoticons);
        }
        
        int[] result = new int[] {0,0};
        for(int i = 0 ; i < 4; i++){
            sale[depth] = SALE_PERCENT[i];
            int[] temp = dfs(depth+1,sale,users,emoticons);
            if(temp[0] > result[0]){
                result = temp;
            }else if(temp[0] == result[0] && temp[1] > result[1]){
                result = temp;
            }
        }
        
        return result;
    }
    
    private int[] cal(int[] sale, int[][] users,int[] emoticons){
        int[] userCost = new int[users.length];
        for(int i = 0 ; i < emoticons.length ; i++){
            for(int j = 0 ; j < users.length ; j++){
                if(sale[i] >= users[j][0]){
                    userCost[j] += (emoticons[i] * (100 - sale[i])) / 100;
                }
            }
        }
        
        int[] result = new int[2];
        for(int i = 0 ; i < users.length ; i++){
            if(userCost[i] >= users[i][1]){
                result[0]++;
            }else{
                result[1] += userCost[i];
            }
        }
        return result;
    }
}