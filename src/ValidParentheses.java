import java.util.ArrayList;
import java.util.Stack;

public class ValidParentheses {

    private static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for( char ch : s.toCharArray()){
            if(isLeftParentheses(ch) ){
                stack.push(ch);
            }
            if(isRightParentheses(ch)){
                if(stack.empty()) return false;
                if(bracketsMatch(ch,stack.pop())){
                    return  false;
                }

            }
        }

        return stack.isEmpty();
    }

    private static boolean isLeftParentheses(char ch){
        return ch == '(' || ch == '[' || ch == '{' ;
    }

    private static boolean isRightParentheses(char ch){
        return ch == '}' || ch == ']' || ch == ')';
    }

    private static boolean bracketsMatch(char right,char left){
        return right == ')'&& left!='(' ||
                right == '}' && left!='{' ||
                right == ']' && left!= '[';
    }

    public static void main(String[] args) {
        System.out.println(isValid("(())"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(}"));
        System.out.println(isValid("([])"));
    }
}
