import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.


Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] numbers){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(numbers);
        for(int i =0;i<numbers.length-2;i++){
            int left =i+1;
            int right = numbers.length-1;
            if(i>0 && numbers[i]==numbers[i-1]){ // logic to avoid duplicates
                continue;
            }
            while(left<right){
                int triplet = numbers[i]+numbers[left]+numbers[right];
                if(triplet==0){
                    res.add(Arrays.asList(numbers[i],numbers[left],numbers[right]));
                    while(left<right && numbers[left]==numbers[left+1]){
                        left++;
                    }
                    while(left<right && numbers[right]==numbers[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(triplet>0){
                    right--;
                }else{
                    left++;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSum(new int[]{0,1,1}));
        System.out.println(threeSum(new int[]{0,0,0}));
    }
}
