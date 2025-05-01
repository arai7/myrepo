class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(0, curr, nums, res);
        return res;
    }

    public void backtrack(int index, List<Integer> curr, int[] nums, List<List<Integer>> res){
        res.add(new ArrayList<>(curr));

        for(int i = index; i < nums.length; i++){
            curr.add(nums[i]);
            backtrack(i+1, curr, nums, res);
            curr.remove(curr.size() - 1);
        }
    }
}
