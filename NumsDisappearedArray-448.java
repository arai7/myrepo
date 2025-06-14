class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++){
            int val = Math.abs(nums[i]);
            int num = nums[val - 1];
            if(num > 0){
                nums[val - 1] = -num;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= 0){
                res.add(i+1);
            }
        }
        return res;
    }
}
