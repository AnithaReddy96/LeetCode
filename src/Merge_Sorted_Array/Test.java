package Merge_Sorted_Array;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        int[] numbers = new int[]{1,2,3,2,4,6,0,5,9,3,8};
        Solution.mergeSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
