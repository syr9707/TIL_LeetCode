import java.util.*;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = -1;
        
        while(start <= end) {
            mid = (start + end) / 2;
            if(nums[mid] < target) start = mid + 1;
            else if(nums[mid] > target) end = mid - 1;
            else return mid;
        }
        
        if(nums[mid] > target) return mid;
        else return mid + 1;
    }
}