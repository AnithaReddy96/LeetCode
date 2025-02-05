package Leetcode;

import java.util.Arrays;

public class RotateArray {

    public static int[] rotateArray(int[] numbers,int k){
        int[] res = new int[numbers.length];
        for(int i =0;i< numbers.length;i++){
            int pos = (i+k)% numbers.length;
            res[pos] = numbers[i];
        }
        return res;
    }

    public static void rotateArrayO1(int[] numbers,int k){
        if(k>numbers.length){
            k = k% numbers.length;
        }

        rotateArray(numbers,0,numbers.length-1);
        rotateArray(numbers,0,k-1);
        rotateArray(numbers,k,numbers.length-1);
    }

    public static void rotateArray(int[] nums,int start,int end){

            while(start<end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }

    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7};
        int[] res = rotateArray(numbers,3);
        System.out.println(Arrays.toString(res));
        rotateArrayO1(numbers,3);
        System.out.println("8888888888888888888888888");
        System.out.println(Arrays.toString(numbers));
    }
}
