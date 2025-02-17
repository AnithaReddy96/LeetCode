package Leetcode.Medium;
/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
 */
public class MergeSortedLists {

    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    private static ListNode mergeSortedLists(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                current.next = l1;
                l1 = l1.next;
            }else{
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if(l1!=null)
            current.next = l1;
        if(l2!=null)
            current.next = l2;

        return dummy.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

       ListNode mergedLists = mergeSortedLists(head1,head2);

       printList(mergedLists);



    }
}
