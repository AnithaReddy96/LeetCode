package Leetcode;

import java.util.Arrays;

/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.



Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.


Constraints:

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109
 */
public class MergeSortedArray {

    public static int[] mergeSort(int[] nums1, int m,int[] nums2, int n){
        int i =m-1;
        int j= n-1;
        int k = m+n-1;

        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k--]=nums1[i--];
            }else
                nums1[k--]=nums2[j--];
        }

        while(i>=0){
            nums1[k--]=nums1[i--];
        }
        while(j>=0){
            nums1[k--]=nums2[j--];
        }
        return nums1;
    }

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
    public static void main(String[] args) {

        int[] numbers = new int[]{1,2,3,2,4,6,0,5,9,3,8};
        MergeSortedArray.mergeSort(numbers);
        System.out.println(Arrays.toString(numbers));

       int[] mergedArray = MergeSortedArray.mergeSort(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
        System.out.println(Arrays.toString(mergedArray));
        int[] mergedArray2 = MergeSortedArray.mergeSort(new int[]{1},1,new int[]{},0);
        System.out.println(Arrays.toString(mergedArray2));
        int[] mergedArray3 = MergeSortedArray.mergeSort(new int[]{0},0,new int[]{1},1);
        System.out.println(Arrays.toString(mergedArray3));

    }
}
