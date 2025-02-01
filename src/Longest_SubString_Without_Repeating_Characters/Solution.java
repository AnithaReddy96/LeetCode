package Longest_SubString_Without_Repeating_Characters;

import java.util.HashSet;

/*Given a string s, find the length of the longest
substring
 without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.*/
public class Solution {
    public static int lengthOfLongestSubString(String str){
        int left =0;
        int maxLength=0;
        HashSet<Character> seen = new HashSet<>();
        for(int right=0;right<str.length();right++){
            char ch = str.charAt(right);
            while(seen.contains(ch)){
                seen.remove(str.charAt(left));
                left++;
            }
            seen.add(ch);
            maxLength = Math.max(maxLength,right-left+1);

        }
       return maxLength;
    }

    public static void main(String[] args) {
      int l=  lengthOfLongestSubString("abcabcbb");
      int m=  lengthOfLongestSubString("bbbbb");
      int n =  lengthOfLongestSubString("pwwkew");

        System.out.println("l="+l +" m="+m+" n="+n);
    }
}
