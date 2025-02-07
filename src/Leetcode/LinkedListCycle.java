package Leetcode;

import java.util.LinkedList;
/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.



Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
Example 2:


Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
Example 3:


Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.

 */
public class LinkedListCycle {

    // Definition for singly-linked list.
    static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
LinkedList<Character> ch = new LinkedList<>();
    /**
     * Detects if a linked list has a cycle.
     *
     * @param head The head of the linked list.
     * @return true if a cycle is found; false otherwise.
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;   // Moves one step at a time.
        ListNode fast = head;   // Moves two steps at a time.

        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move slow pointer one step.
            fast = fast.next.next;    // Move fast pointer two steps.

            // If both pointers meet, there's a cycle.
            if (slow == fast) {
                return true;
            }
        }
        // If fast pointer reaches the end, there is no cycle.
        return false;
    }

    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Introduce a cycle for testing:
        // Link the next pointer of node 5 back to node 3.
        head.next.next.next.next.next = head.next.next;

        // Check for cycle
        if (hasCycle(head)) {
            System.out.println("Cycle detected in the linked list.");
        } else {
            System.out.println("No cycle found in the linked list.");
        }
    }
}
