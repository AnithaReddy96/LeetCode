package Leetcode.Hard;

import Leetcode.LinkedListCycle;

/*
Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:


Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []


Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000


Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {
    static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    private static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;
        while(curr!=null){
            curr.next = prev;
            prev=curr;
            curr =next;
            if(next!=null){
                next = curr.next;
            }
        }
        head = prev;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = reverseList(head);
        printList(head);

    }

    public static void printList(ListNode head){
        ListNode curr = head;
        while(curr!=null){
            System.out.print(curr.val+" ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
