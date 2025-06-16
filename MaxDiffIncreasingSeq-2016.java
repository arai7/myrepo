class Solution {
    public int maximumDifference(int[] nums) {
        int minSoFar = Integer.MAX_VALUE;
        int maxDiff = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] < minSoFar){
                minSoFar = nums[i];
            }

            else if(nums[i] - minSoFar > maxDiff){
                maxDiff = nums[i] - minSoFar;
            }
        }

        return (maxDiff > 0 ? maxDiff : -1);  
    }
}
