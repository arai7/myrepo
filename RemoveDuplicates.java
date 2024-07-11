class Solution {
    public int removeDuplicates(int[] nums) {
        int[] numsCopy =nums;
        int itr = 1;

        int currEle = nums[0];
        for(int i =1; i<nums.length; i++){
            
            if(currEle == nums[i]){
                continue;
            }
            else{
                numsCopy[itr] = nums[i];
                itr++;
                currEle = nums[i];
            }
            
        }

        nums = numsCopy;
        return itr;
    }
}
