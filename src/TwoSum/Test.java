package TwoSum;

import java.util.List;

public class Test {
    public static void main(String[] args) {


        int[] nums = {4,6,9,3,2,9,2,8};
        int target = 11;
       int[] res = TwoSumUtil.twoSumSimple(nums,target);
        System.out.println(res[0]+" "+res[1]);

        int[] res2 = TwoSumUtil.twoSimpleHashMap(nums,target);
        System.out.println(res2[0]+" "+res2[1]);

        List<int[]> allPairs = TwoSumUtil.findAllPairs(nums,target);
        for(int[] pair: allPairs) {
            System.out.println(pair[0] + " " + pair[1]);
        }

       List<List<Integer>> result = TwoSumUtil.findAllPairsHashMap(nums,target);
        System.out.println("*************************************");
        for(List<Integer> list: result)
            System.out.println(list.get(0)+" "+list.get(1));
    }
}
