class Solution {
    public boolean canJump(int[] nums) {
        
        if(nums.length ==1 ){
            return true;
        }
        if(nums[0]==0){
            return false;
        }
        
        int count = 0;
        boolean flag = false;

        for(int i = nums.length -2; i >= 0; i--){
            if(nums[i] == 0){
                flag = true;
                count++;
                continue;
            }

            if(flag && nums[i] <= count){
                count++;
            }
            else if(flag && count!= nums[i]){
                count = 0;
                flag = false;
            }
            else{
                flag = false;
            }

        }
        return !flag;
    }
}
