
class Solution {

    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        findSubset(nums, 0, curr, ans);
        return ans;
    }

    public static void findSubset(int[] nums, int i, List<Integer> curr, List<List<Integer>> ans) {
        // Base case: If we've processed all elements, add the current subset
        if (i == nums.length) {
            ans.add(new ArrayList<>(curr)); // Create a copy of the current subset
            return;
        }

        // Include nums[i] in the current subset
        curr.add(nums[i]);
        findSubset(nums, i + 1, curr, ans);

        // Exclude nums[i] (backtrack)
        curr.remove(curr.size() - 1);
        findSubset(nums, i + 1, curr, ans);
    }
}
