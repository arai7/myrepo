class Solution {
    public int removeElement(int[] nums, int val) {
        int[] numsCopy = nums;
        int itr = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]==val){
                continue;
            }
            else{
                numsCopy[itr]=nums[i];
                itr++;
            }
        }
        return itr;
    }
}
