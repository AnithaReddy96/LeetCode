package Leetcode;

import java.util.HashMap;

/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.



Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 */
public class RansomNote {

    public static boolean ransomNote(String ransomNote,String magazine){
        int count=0;
        HashMap<Character,Integer> mag_map = new HashMap<>();
        for(int i=0;i<magazine.length();i++){
            char ch = magazine.charAt(i);
            mag_map.put(ch,mag_map.getOrDefault(ch,0)+1);
        }

        for(int i =0;i<ransomNote.length();i++){
            char ch = ransomNote.charAt(i);
            if(mag_map.containsKey(ch) && mag_map.get(ch)>0){
                count++;
                mag_map.put(ch,mag_map.get(ch)-1);
            }
        }
        return ransomNote.length()==count;
    }

    public static void main(String[] args) {
        System.out.println(ransomNote("a","aa"));
        System.out.println(ransomNote("a","ab"));
        System.out.println(ransomNote("aab","aaccfrgh"));
    }
}
