class Solution {
    public int majorityElement(int[] nums) {
        /*HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hashMap.containsKey(nums[i])){
                int count = hashMap.get(nums[i]);
                if(count>=(nums.length)/2){
                    return nums[i];
                }
                hashMap.put(nums[i],count+1);
            }
            else{
                hashMap.put(nums[i],1);
            }
        }
        return nums[0];*/
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
