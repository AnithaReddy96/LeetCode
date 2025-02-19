package Leetcode;

import java.util.Stack;

/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.



Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.


Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
 */
public class ValidPalindrome {

    public static boolean isPalindrome(String s){
        s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int left =0;
        int right =s.length()-1;

        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));
    }

    public static class ValidParentheses {

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

    /*
        You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

        You may assume the two numbers do not contain any leading zero, except the number 0 itself.



        Example 1:


        Input: l1 = [2,4,3], l2 = [5,6,4]
        Output: [7,0,8]
        Explanation: 342 + 465 = 807.
        Example 2:

        Input: l1 = [0], l2 = [0]
        Output: [0]
        Example 3:

        Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        Output: [8,9,9,9,0,0,0,1]


        Constraints:

        The number of nodes in each linked list is in the range [1, 100].
        0 <= Node.val <= 9
        It is guaranteed that the list represents a number that does not have leading zeros.
         */
    public static class AddTwoNumbers {
        static class ListNode{
            int val;
            ListNode next;

            public ListNode(int val){
                this.val = val;
                this.next = null;
            }
        }
        private static ListNode addTwoNumbers(ListNode l1, ListNode l2){
            ListNode l3 = null;
            ListNode current = null;
            int carry =0;
            while(l1!=null || l2!=null || carry!=0){
                int sum = carry;
                if(l1!=null){
                    sum += l1.val;
                    l1 = l1.next;
                }
                if(l2!=null){
                    sum += l2.val;
                    l2 = l2.next;
                }
                carry = sum/10;
                int digit = sum%10;
                ListNode newNode = new ListNode(digit);
                if(l3==null){
                    l3 = newNode;
                    current = l3;
                }else{
                    current.next = newNode;
                    current = current.next;
                }
            }
            return l3;
        }

        private static void printList(ListNode head) {
            ListNode current = head;
            while (current != null) {
                System.out.print(current.val);
                if (current.next != null) {
                    System.out.print(" → ");
                }
                current = current.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            // Creating first linked list: 2 → 4 → 3 (342)
            ListNode l1 = new ListNode(2);
            l1.next = new ListNode(4);
            l1.next.next = new ListNode(3);

            // Creating second linked list: 5 → 6 → 4 (465)
            ListNode l2 = new ListNode(5);
            l2.next = new ListNode(6);
            l2.next.next = new ListNode(4);

            ListNode result = addTwoNumbers(l1, l2);

            System.out.print("Final Result: ");
            printList(result);
        }
    }

    public static class MinStack {
    }
}
