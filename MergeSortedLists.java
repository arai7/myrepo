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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null){
            return null;
        }
        if(list1 == null && list2 != null){
            return list2;
        }
        if(list1 != null && list2 == null){
            return list1;
        }

        ListNode merged = new ListNode();
        ListNode head = merged;
        
        while(list1 != null && list2 != null){
            ListNode node = new ListNode();
            if(list1.val < list2.val){
                node.val = list1.val;
                merged.next = node;
                merged = merged.next;
                list1 = list1.next;
            }
            else{
                node.val = list2.val;
                merged.next = node;
                merged = merged.next;
                list2 = list2.next;
            }
        }

        if(list1 == null){
            merged.next = list2;
        }
        else{
            merged.next = list1;
        }
        
        return head.next;
    }
}
