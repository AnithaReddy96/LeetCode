package Leetcode;

import java.util.Arrays;
import java.util.HashMap;

/*
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:

Each letter in pattern maps to exactly one unique word in s.
Each unique word in s maps to exactly one letter in pattern.
No two letters map to the same word, and no two words map to the same letter.


Example 1:

Input: pattern = "abba", s = "dog cat cat dog"

Output: true

Explanation:

The bijection can be established as:

'a' maps to "dog".
'b' maps to "cat".
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"

Output: false

Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"

Output: false
 */
public class WordPattern {
    private static boolean wordPattern(String pattern,String s){
        String[] words = s.split("\\s+");
        if(pattern.length()!=words.length){
            return false;
        }
        HashMap<Character,String> pattern_map = new HashMap<>();
        HashMap<String,Character> word_map = new HashMap<>();

        for(int i =0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            String word = words[i];
            if(!pattern_map.containsKey(ch)){
                if(word_map.containsKey(word)){
                    return false;
                }else{
                    pattern_map.put(ch,word);
                    word_map.put(word,ch);
                }
            }else{
                String mappedWord = pattern_map.get(ch);
                if(!mappedWord.equals(word)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog cat cat dog"));
        System.out.println(wordPattern("abba","dog cat cat fish"));
        System.out.println(wordPattern("aaaa","dog cat cat dog"));
    }

    public static class AddTwoNumbersUsingArray {

        private static int[] addTwoNumbers(int[] i1,int[] i2){
            int maxLength = Math.max(i1.length, i2.length);
            int[] i3 = new int[maxLength+1];

            int carry = 0;
            int i=i1.length-1; int j=i2.length-1; int k=maxLength;
            int sum =0;

            while(i>=0 || j>=0 || carry!=0){
                sum = carry;

                if(i>=0){
                    sum = sum+i1[i--];
                }
                if(j>=0){
                    sum = sum+i2[j--];
                }

                carry = sum/10;

                i3[k--]= sum%10;;

            }
            if(i3[0]==0){
                i3 = Arrays.copyOfRange(i3,1,i3.length);
            }

            return i3;
        }

        public static void main(String[] args) {
            System.out.println(Arrays.toString(addTwoNumbers(new int[]{2,4,3}, new int[]{5,6,4})));
        }
    }
}
