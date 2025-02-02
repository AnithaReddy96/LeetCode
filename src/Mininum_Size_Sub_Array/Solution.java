package Mininum_Size_Sub_Array;
/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a
subarray
 whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.



Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0


Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104

 */
public class Solution {
    public static int minSubArray(int[] nums,int target){
        int left=0;
        int minLength = Integer.MAX_VALUE;
        int curr=0;
        for(int right=0;right<nums.length;right++){
            curr = curr+nums[right];
            while(curr>=target){
                curr = curr-nums[left];
                minLength = Math.min(minLength,right-left+1);
                left++;
            }

        }

        return minLength==Integer.MAX_VALUE ? 0:minLength;
    }

    public static void main(String[] args) {
        System.out.println(minSubArray(new int[]{2,3,1,2,4,3},7));
        System.out.println(minSubArray(new int[]{1,4,4},4));
        System.out.println(minSubArray(new int[]{1,1,1,1,1,1,1,1},11));
    }
}
