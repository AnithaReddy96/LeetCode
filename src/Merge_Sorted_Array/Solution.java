package Merge_Sorted_Array;

public class Solution {

    public static void mergeSort(int[] numbers){
        if(numbers.length==1)
            return;
        int middle = numbers.length/2;
        int[] left = new int[middle];
        int[] right = new int[numbers.length-middle];

        for (int i =0;i<middle;i++){
            left[i] = numbers[i];
        }
        for (int i = middle;i<numbers.length;i++){
            right[i-middle]=numbers[i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(left,right,numbers);
    }

    private static void merge(int[] left, int[] right, int[] numbers) {
        int i=0,j=0,k=0;

        while(i<left.length && j< right.length){
            if(left[i]<right[j]){
                numbers[k++]=left[i++];
            }else
                numbers[k++]=right[j++];
        }

        while(i<left.length)
            numbers[k++]=left[i++];
        while(j<right.length)
            numbers[k++]=right[j++];

    }
}
