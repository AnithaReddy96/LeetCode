package Streams;

import java.util.stream.IntStream;

public class NumberOperations {

    public static void main(String[] args) {
        // find missing number in range 1 to N

        int[] arr = {1, 2, 4, 5, 6};
        int N = arr.length+1;
        int missingNumber = IntStream.rangeClosed(1, N).sum() - IntStream.of(arr).sum();
        System.out.println(missingNumber);

        // using java 7

        int total = N*(N+1)/2;
        int actual = 0;

        for(int i=0;i<arr.length;i++){
            actual = actual+arr[i];
        }

        int miss = total-actual;
        System.out.println(miss);


    }

}
