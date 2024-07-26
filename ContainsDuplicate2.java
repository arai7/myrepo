class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k==0){
            return false;
        }
        
        int diff = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }
            else{
                int prevIndex = map.get(nums[i]);
                if(i-prevIndex <= k){
                    return true;
                }
                else{
                    map.put(nums[i], i);
                }
            }
        }
        return false;
    }
}
