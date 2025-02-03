import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.


Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */
public class TwoSum {


    public static int[] twoSumSimple(int[] nums, int target){

        int[] res = new int[2];

        for(int i = 0;i<nums.length;i++){
            for (int j = i+1;j<nums.length;j++){

                if(nums[i]+nums[j]==target){
                    res[0]=i;
                    res[1]=j;
                    break;
                }
            }
        }

        return res;
    }


    public static int[] twoSimpleHashMap(int[] nums,int target){

        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0;i<nums.length;i++){
            int compliment = target-nums[i];

            if(map.containsKey(compliment)){
               res[0] = i;
               res[1] = map.get(compliment);
               break;
            }else{
                map.put(nums[i],i);
            }

        }
        return res;
    }


    public static List<int[]> findAllPairs(int[] nums, int target){

       // HashMap<Integer,Integer> map = new HashMap<>();
      //  HashSet<String> seen = new HashSet<>();
        List<int[]> result = new ArrayList<>();
        for(int i =0;i<nums.length;i++){

            for(int j = i+1; j<nums.length;j++){
            //    String pair = nums[i]+" "+nums[j];

                if(nums[i]+nums[j]==target){
                 //   if(!seen.contains(pair)){
                    result.add(new int[]{i,j});
                     //   seen.add(pair);
                   // }
                }
            }
        }
        return result;

    }


    public static List<List<Integer>> findAllPairsHashMap(int[] nums,int target){

        List<List<Integer>> result = new ArrayList<>();

        HashMap<Integer,Integer>  map = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            int x = target-nums[i];
            map.put(nums[i],i);
            if(map.containsKey(x)){
                result.add(List.of(i,map.get(x)));
            }
        }
        return result;

    }

    public static void main(String[] args) {


        int[] nums = {4,6,9,3,2,9,2,8};
        int target = 11;
        int[] res = TwoSum.twoSumSimple(nums,target);
        System.out.println(res[0]+" "+res[1]);

        int[] res2 = TwoSum.twoSimpleHashMap(nums,target);
        System.out.println(res2[0]+" "+res2[1]);

        List<int[]> allPairs = TwoSum.findAllPairs(nums,target);
        for(int[] pair: allPairs) {
            System.out.println(pair[0] + " " + pair[1]);
        }

        List<List<Integer>> result = TwoSum.findAllPairsHashMap(nums,target);
        System.out.println("*************************************");
        for(List<Integer> list: result)
            System.out.println(list.get(0)+" "+list.get(1));
    }
}
