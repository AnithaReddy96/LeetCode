package Leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
/*
Given an array of strings strs, group the
anagrams
 together. You can return the answer in any order.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]



Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(List<String> words){
        HashMap<String,List<String>> map = new HashMap<>();
        for (String word : words) {
            String sortedWord = sort(word);

            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values());

    }

    private static String sort(String str){
        return str.chars().sorted().mapToObj(ch ->String.valueOf((char)ch)).collect(Collectors.joining());
    }

    public static void main(String[] args) {

        List<List<String>> res = groupAnagrams(Arrays.asList("eat","tea","tan","ate","nat","bat") );
        System.out.println(res);
    }
}
