package Leetcode.Medium;

import java.util.HashMap;

/*
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.



Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false

 */
public class ContainDuplicates2 {

    private static boolean containsDuplicates2(int[] nums,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
          if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }else{
              int diff = Math.abs(i-map.get(nums[i]));
              if(diff<=k){
                  return true;
              }else{
                  map.put(nums[i],i);
              }
          }

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicates2(new int[]{1,2,3,1},3));
        System.out.println(containsDuplicates2(new int[]{1,2,3,1,2,3},2));
    }
}
