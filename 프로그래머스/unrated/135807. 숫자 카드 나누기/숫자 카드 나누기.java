import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        List<Integer> divisorsA = this.getDivisors(arrayA); // arrayA를 모두 나눌 수 있는 숫자
        List<Integer> divisorsB = this.getDivisors(arrayB); // arrayB를 모두 나눌 수 있는 숫자

        int targetA = this.getMaxNonDivisor(arrayB, divisorsA);
        int targetB = this.getMaxNonDivisor(arrayA, divisorsB);

        return Math.max(targetA, targetB);
    }

    public int getMaxNonDivisor(int[] arrays, List<Integer> divisors) {
        int target = 0;
        for (int divisor : divisors) {
            boolean isNoDivide = true;
            for (int number : arrays) {
                if (number % divisor == 0) {
                    isNoDivide = false;
                    break;
                }
            }
            if (isNoDivide) {
                target = Math.max(target, divisor);
            }
        }
        return target;
    }

    public List<Integer> getDivisors(int[] arrays) {
        List<Integer> list = new ArrayList<>();
        int length = arrays.length;
        int min = arrays[0];
        for (int i = 2; i <= min; i++) {
            boolean isDivide = true;
            for (int j = 0; j < length; j++) {
                if (arrays[j] % i != 0) {
                    isDivide = false;
                    break;
                }
            }
            if (isDivide) {
                list.add(i);
            }
        }
        return list;
    }
}