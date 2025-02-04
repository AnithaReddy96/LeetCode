package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class ReductionAndAggregation {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(2,5,9,7,4,0);
        System.out.println(sumOfElements(numbers));
        maxAndMin(numbers);

    }
    //Find the Sum of All Elements in a List
    public static int sumOfElements(List<Integer> nums){
       //return nums.stream().mapToInt(Integer::valueOf).sum();
      return nums.stream().reduce(0, Integer::sum);
    }
    //Find the Maximum and Minimum in a List
    public static void maxAndMin(List<Integer> nums){
        Optional<Integer> max = nums.stream().max(Integer::compareTo);
        Optional<Integer> min = nums.stream().min(Integer::compareTo);
        System.out.println("Max="+max.orElse(-1)+" Min="+min.orElse(-1));
    }

    //Count the Number of Elements in a List
    
    public static void count(List<Integer> nums){
        long count = nums.stream().count();
        System.out.println("Count="+count);
    }


}
