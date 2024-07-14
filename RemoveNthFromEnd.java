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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        ListNode start = head;
        ListNode nth = head;
        int count = 0;

        while(count < n ){
            
            node = node.next;
            nth = node;
            count++;
        }
        if(nth ==null){
            return start.next;
        }

        
        while(nth.next != null){
            start = start.next;
            nth = nth.next;
        }
            start.next = start.next.next;

        return head;
    }
}
