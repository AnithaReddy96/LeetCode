package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class StringOperations {
    public static void main(String[] args) {
        //Reverse a string without using extra space.

        String name = "anitha";

        char[] chars = name.toCharArray();
        int left=0;
        int right =name.length()-1;

        while(left<right){
            chars[left] ^= chars[right];
            chars[right] ^= chars[left];
            chars[left] ^= chars[right];
            left++;
            right--;
        }

        System.out.println("Reversed String "+new String(chars));


        //FlatNumSum

        String[] flatNumbers = {
                "0101", "0201", "0301", "0401", "0501", "0604", "0701", "0801",
                "0901", "1001", "1101", "1201", "1301", "1401", "1501", "1601",
                "1701", "1801", "0102", "0202", "0302", "0402"
        };

        List<String> filteredStrings = Arrays.stream(flatNumbers)
                .filter(number -> number.chars().map(Character::getNumericValue).sum()==10)
                .toList();

        filteredStrings.forEach(str -> System.out.println(str));

        // sort map by key length

        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Cherry", 30);
        map.put("Kiwi", 40);
        map.put("Mango", 50);
        map.put("Watermelon", 60);


        map.entrySet().stream().sorted(Comparator.comparingInt(entry -> entry.getKey().length()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e1,LinkedHashMap::new));

        // filter number from a string sentence

        String str = "Today is sunny 20 Feb day";

        Arrays.stream(str.split(" "))
                .filter(word -> word.matches("\\d+")).findFirst().orElse("No number found");
        System.out.println(str.replace("[a-zA-z]",""));
    }
}
