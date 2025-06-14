class Solution {
    public int[] findErrorNums(int[] nums) {
        //List<Integer> res = new ArrayList<Integer>();
        int[] res = new int[2];

        for(int i = 0; i < nums.length; i++){
            int val = Math.abs(nums[i]);
            int num = nums[val - 1];
            if(num > 0){
                nums[val - 1] = -num;
            }
            else{
                res[0] = val;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= 0){
                res[1] = i+1;
            }
        }
        
        return res;
    }
}
