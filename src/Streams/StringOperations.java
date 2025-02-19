package Streams;

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
    }
}
