package Missileanous;

import java.util.Arrays;

public class OpenText {

    public static void main(String[] args) {
        String str = "4bat32 are rat45";

        String[] words = str.split(" ");


        System.out.println(returnResult(words));

    }

    public static String returnResult(String[] words){
        StringBuilder result = new StringBuilder();
        for(String word : words){
            if(!word.contains("t")){
                result.append("none").append(",");
            }else{
                int sum = word.chars().filter(Character::isDigit).map(Character::getNumericValue).sum();
                if(sum!=0){
                    result.append(word).append("(").append(sum).append(")").append(",");
                }
            }
        }
        if(!result.isEmpty()){
            result.setLength(result.length()-1);
        }
        return result.toString();
    }


    public static int sumOfDigits(String str){
        int sum = 0;
        for(char ch : str.toCharArray()){
            if(Character.isDigit(ch)){
                sum += Character.getNumericValue(ch);
            }
        }
        return sum;
    }
}
