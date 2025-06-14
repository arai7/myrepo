class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++){
            int val = Math.abs(nums[i]);
            int num = nums[val - 1];
            if(num > 0){
                nums[val - 1] = -num;
            }
            else{
                res.add(val);
            }
        }
        return res;
    }
}
