class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        
        int productSoFar = nums[0];
        for(int i = 0; i < n; i++){
            if(i==0){
                prefix[0] = 1;
            }else{
                prefix[i] = productSoFar;
                productSoFar = productSoFar * nums[i];
            }
        }

        int productSoFar2 = nums[n-1];
        for(int i = n-1; i >= 0; i--){
            if(i == n-1){
                suffix[i] = 1;
                nums[i] = prefix[i]*suffix[i];
            }else{
                suffix[i] = productSoFar2;
                productSoFar2 = productSoFar2 * nums[i];
                nums[i] = prefix[i]*suffix[i];
            } 
        }
        
        return nums;
    }
}
