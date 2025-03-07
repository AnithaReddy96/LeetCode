import java.util.Arrays;

public class ShilftLeftAll1s {

    public static void main(String[] args) {
        int[] nums = {2,0,1,4,1,5,6,1,4,0,9,1,1};

       shiftLeft(nums);
        System.out.println(Arrays.toString(nums));
        shiftRight(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void shiftRight(int[] nums) {
        // use two pointers i,j i from left and j from right
        int left = nums.length-1;

        for(int right=nums.length-1;right>=0;right--){
            if(nums[right]==1){
                int temp = nums[right];
                nums[right]= nums[left];
                nums[left] = temp;
                left--;
            }
        }

    }


    private static void shiftLeft(int[] nums){
        int left =0;
        for(int right = 0;right<nums.length;right++){
            if(nums[right]==1){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }
}

