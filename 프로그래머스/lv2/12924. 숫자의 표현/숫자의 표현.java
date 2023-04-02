import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;

        for(int i=1; i<=n; i++) {
            int sum = 0;
            for(int j=i; j<=n; j++) {
                sum += j;

                if(sum==n) {
                    answer++;
                    break;
                } 
                else if(sum>n) {
                    break;
                }
            }
        }      
        return answer;
    }
}

// class Solution {
//     public int solution(int n) {
//         int answer = 0;
        
//         boolean[] check = new boolean[n];
//         LinkedList<Integer> q = new LinkedList<>();
//         for(int i = 1; i <= n; i++) {
//             int sum = 0;
//             for(int j = i; j <= n; j++) {
//                 if(check[j - 1] == true) break;
//                 sum += j;
//                 q.add(j);
//                 if(sum > n) {
//                     while(sum < n) {
//                         sum = sum - q.poll();
//                     }
//                 }
//                 else if(sum == n) {
//                     answer++;
//                     check[q.peek() - 1] = true;
//                     q.clear();
//                     break;
//                 }
//             }
//         }
        
//         return answer;
//     }
// }
