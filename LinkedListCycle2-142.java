public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;

        while (slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                isCycle = true;
                break;
            }
        }

        if(isCycle){
            fast = head;
            while(fast != slow){
                slow = slow.next;
                fast = fast.next;
            }
            return fast;
        }

        return null;
    }
}
