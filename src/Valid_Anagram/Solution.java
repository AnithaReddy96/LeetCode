package Valid_Anagram;

import java.util.stream.Collectors;

/*
Given two strings s and t, return true if t is an
anagram
 of s, and false otherwise.



Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false



Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 */
public class Solution {

    public static boolean isAnagram(String s, String t){
        return normalizeString(s).equals(normalizeString(t));
    }

    public static String normalizeString(String s){
       return  s.chars().sorted().mapToObj(ch ->String.valueOf((char)ch)).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram","nagaram"));
        System.out.println(isAnagram("rat","car"));
    }

}
