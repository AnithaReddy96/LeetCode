package Leetcode;


import java.util.HashMap;
import java.util.Objects;

/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.



Example 1:

Input: s = "egg", t = "add"

Output: true

Explanation:

The strings s and t can be made identical by:

Mapping 'e' to 'a'.
Mapping 'g' to 'd'.
Example 2:

Input: s = "foo", t = "bar"

Output: false

Explanation:

The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

Example 3:

Input: s = "paper", t = "title"

Output: true


 */
public class IsomorphicStrings {

    private static boolean isIsomorphic(String s, String t){
        if(s.length()!=t.length())
            return false;
        HashMap<Character,Integer> s_map = new HashMap<>();
        HashMap<Character,Integer> t_map = new HashMap<>();

        for(int i =0;i<s.length();i++){
            s_map.putIfAbsent(s.charAt(i),i);
            t_map.putIfAbsent(t.charAt(i),i);

            if(!Objects.equals(s_map.get(s.charAt(i)), t_map.get(t.charAt(i)))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg","add"));
        System.out.println(isIsomorphic("paper","title"));
        System.out.println(isIsomorphic("foo","boi"));
    }
}
