package Streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdvancedStreamOperations {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(2,5,9,7,4,0);
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        List<String> names = Arrays.asList("apple", "", null, "banana", "cherry", null);
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "banana");

        //Find the Second-Highest Number in a List
        Optional<Integer> first = numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        first.ifPresent(System.out::println);
        //Flatten a List of Lists

        List<Integer> flattendList = listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(flattendList);

        //Check if a List Contains a Specific Value
        boolean hasValue = numbers.stream().anyMatch(n -> n == 4);
        System.out.println(hasValue);

        //Remove Null or Empty Values from a List
        List<String> filteredStrings = names.stream().filter(s -> s != null && !s.isEmpty()).toList();
        System.out.println(filteredStrings);

        //Find the Frequency of Each Element in a List
        Map<String, Long> frequencyMap = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        frequencyMap.forEach((name,count)->{
            System.out.println("Name:"+name+" count:"+count);
        });

    }
}
