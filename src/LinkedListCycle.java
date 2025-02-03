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
