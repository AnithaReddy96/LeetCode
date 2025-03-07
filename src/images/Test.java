package images;

import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        String s = "My name is Anitha and I am a Java Developer.";

        s.chars().mapToObj(ch -> (char)ch).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + " " + entry.getValue());
                });

    }

}
