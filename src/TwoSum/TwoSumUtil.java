package TwoSum;

import java.util.*;

public class TwoSumUtil {


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

}
