import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> saveOrder = new Stack<Integer>();

        int defaultOrder = 1;
        int wantOrderIdx = 0;

        while (true) {
            if (!saveOrder.isEmpty() && order[wantOrderIdx] == saveOrder.peek()) {
                answer++;

                wantOrderIdx++;
                saveOrder.pop();

                continue;
            }

            if (defaultOrder > order.length)
                break;

            if (order[wantOrderIdx] == defaultOrder) {
                answer++;

                wantOrderIdx++;
                defaultOrder++;

                continue;
            }

            saveOrder.push(defaultOrder);
            defaultOrder++;
        }

        return answer;
    }
}
