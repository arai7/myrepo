class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0]; // 🟢 Start both from the same point

        // Phase 1: Detect cycle
        do {
            slow = nums[slow]a;
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find entry point
        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
