/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;// Edge cases: empty list or no need to reverse
        }
        // list node to simplify handling of edge case when left is 1
        ListNode list = new ListNode(0);
        list.next = head;

        // Step 1: Traverse to the node just before the left position
        ListNode prev = list;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 2: Reverse the sublist from left to right in place
        ListNode current = prev.next;
        ListNode nextNode = null;

        for (int i = 0; i < right - left; i++) {
            nextNode = current.next;
            current.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }

        // Step 3: Return the updated head of the linked list
        return list.next;
    }
}
