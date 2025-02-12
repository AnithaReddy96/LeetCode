package Leetcode;

/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).



Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false

 */
public class IsSubSequence {
    public static boolean isSubsequence(String s, String t){
        int left =0;
        int right =0;
        int count=0;

        while(left<s.length() && right<t.length()){
            if(s.charAt(left)==t.charAt(right)){
                left++;
                right++;
                count++;
            }else{
                right++;
            }
        }
        return s.length()==count;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc","ahbgdc"));
        System.out.println(isSubsequence("axc","ahbgdc"));
    }
}
