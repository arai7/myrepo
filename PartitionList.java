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
    public ListNode partition(ListNode head, int x) {
        ListNode pointer = head;
        ListNode small = new ListNode();
        ListNode small_head = small;
        ListNode large = new ListNode();
        ListNode large_head = large;

        while(pointer != null){
            ListNode temp = new ListNode();
            if(pointer.val < x){
                temp.val = pointer.val;
                small.next = temp;
                small = small.next;
            }else{
                temp.val = pointer.val;
                large.next = temp;
                large = large.next;
            }
            pointer = pointer.next;
        }
        small.next = large_head.next;
        return small_head.next;
    }
}
