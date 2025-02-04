package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BasicOperations {


    //List<String> names = Arrays.asList("anitha", "madika", "java");
    public static void main(String[] args) {
        List<String> names = Arrays.asList("anitha", "madika", "java");
        System.out.println(toUpperCase(names));
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(evenNumbers(numbers));
        System.out.println(firstEven(numbers));

        //multiply elements in a list
        Optional<Integer> reduce = numbers.stream().reduce((a, b) -> a * b);
        reduce.ifPresent(System.out::println);

    }

    //Convert a List of Strings to Uppercase
    public static List<String> toUpperCase(List<String> names){
       return names.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    //Filter Even Numbers from a List
    public static List<Integer> evenNumbers(List<Integer> numbers){
        return numbers.stream().filter(num ->num%2==0).collect(Collectors.toList());
    }

    //Find the First Even Number in a List
    public static int firstEven(List<Integer> numbers){
        return numbers.stream().filter(num ->num%2==0).findFirst().orElse(-1);
    }
   
    
}
