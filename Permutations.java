class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        List<Integer> current = new ArrayList<>();
        backtrack(nums, res, used, current);
        return res;
    }

    public void backtrack(int[] nums, List<List<Integer>> res, boolean[] used, List<Integer> current){
        if(current.size() == nums.length){
            res.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!used[i]){
                current.add(nums[i]);
                used[i] = true;;
                backtrack(nums, res, used, current);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }
}
