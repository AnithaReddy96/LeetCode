package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOperations {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("apple", "banana", "cherry");
        System.out.println(sortStrings(names));
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        System.out.println(getUniqueElements(numbers));
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        System.out.println(concatLists(list1,list2));
    }
    //Sort a List of Strings in Reverse Order
    public static List<String> sortStrings(List<String> names){
       return names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    //Get Distinct Elements from a List
    public static List<Integer> getUniqueElements(List<Integer> nums){
        return nums.stream().distinct().collect(Collectors.toList());
    }

    //Concatenate Two Lists Using Streams
    public static List<Integer> concatLists(List<Integer> list1,List<Integer> list2){
      // return Stream.of(list1,list2).flatMap(List::stream).collect(Collectors.toList());
      return Stream.concat(list1.stream(),list2.stream()).collect(Collectors.toList());
    }


}
