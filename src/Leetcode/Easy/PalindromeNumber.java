package Leetcode.Easy;
/*
Given an integer x, return true if x is a
palindrome
, and false otherwise.



Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */
public class PalindromeNumber {
    private static boolean isPalindrome(int number){
        String num = String.valueOf(number);
       int left = 0;
       int right = num.length()-1;
       while(left<right){
           if(num.charAt(left)!=num.charAt(right)){
               return false;
           }
           left++;
           right--;
       }
       return true;

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(1221));
        System.out.println(isPalindrome(1234));
    }
}
