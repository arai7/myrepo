class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = nums.length;
        int complement = 0;
        int[] res = new int[2];
        for(int i = 0; i < n; i++){
            complement = target - nums[i];
            if(map.containsKey(complement)){
                res[0] = i;
                res[1] = map.get(complement);
            }
            else{
                map.put(nums[i], i);
            }
        }
        return res;
    }
}
