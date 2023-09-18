import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        Stack<String[]> stop = new Stack<>();
        
        Arrays.sort(plans,(a,b)->ToSec(a[1])-(ToSec(b[1])));
        
        int size = plans.length;
        
        int z=0;
        int idx=0;
        int current=0;
        String type ="";
        int time =0;
        int period =0;
        int next=0;       
        
        while(size!=idx){
            
            type=plans[idx][0];
            time = ToSec(plans[idx][1]);
            period = Integer.parseInt(plans[idx][2]);
            
            current=time+period;
            
            if(size-1!=idx){      
             next = ToSec(plans[idx+1][1]);
            if(current>next){
               
                stop.push(new String[]{type,current-next+""});
                current=next;
                idx++;
                
                continue;
                
                }
            }
            
            answer[z++]=type;
            
            while(!stop.isEmpty()){
                
                int remain = next-current;
                
                String[] work = stop.pop();
                
                int re_p =Integer.parseInt(work[1]);
                
                if(remain>=re_p){
                    
                    answer[z++]=work[0];
                    current+=re_p;
                } else{       
                    stop.push(new String[]{work[0],re_p-remain+""});
                    break;
                }
                  
            }
            
            idx++;
        }
        
        while(!stop.isEmpty()){
            answer[z++]=stop.pop()[0];
        }
        
        return answer;
    }
    
    public int ToSec (String time){
        
        String[] t = time.split(":");
        int h =Integer.parseInt(t[0])*60;
        int m =Integer.parseInt(t[1]);
        
        return h+m;
    }
}