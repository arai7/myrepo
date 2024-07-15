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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carry = false;
        ListNode res = new ListNode();
        ListNode head = res;

        while(l1 != null && l2 != null){
            ListNode temp = new ListNode();
            temp.val = l1.val + l2.val;
            if(carry){
                temp.val += 1;
                carry = false;
            }
            if(temp.val >= 10){
                temp.val = temp.val%10;
                carry = true;
            }
            res.next = temp;
            l1 = l1.next;
            l2 = l2.next;
            res = res.next;
        }

        if(l2 == null && l1 == null && carry){
            ListNode temp = new ListNode();
            temp.val = 1;
            res.next = temp;
            carry = false;
        }

        else if(l2 == null && l1 != null){
            while(l1 != null){
                ListNode temp = new ListNode();
                temp.val = l1.val;
                if(carry){
                    temp.val += 1;
                    carry = false;
                }
                if(temp.val >= 10){
                    temp.val = temp.val%10;
                    carry = true;
                }
                res.next = temp;
                l1 = l1.next;
                res = res.next;
            }
            if(carry){
                ListNode temp = new ListNode();
                temp.val = 1;
                res.next = temp;
                carry = false;
            }
        }

        else if(l1 == null && l2 != null){
            while(l2 != null){
                ListNode temp = new ListNode();
                temp.val = l2.val;
                if(carry){
                    temp.val += 1;
                    carry = false;
                }
                if(temp.val >= 10){
                    temp.val = temp.val%10;
                    carry = true;
                }
                res.next = temp;
                l2 = l2.next;
                res = res.next;
            }
            if(carry){
                ListNode temp = new ListNode();
                temp.val = 1;
                res.next = temp;
                carry = false;
            }
        }

        return head.next;
    }
}
