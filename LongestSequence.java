class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        HashSet<Integer> set = new HashSet<>();

        int max = 1;

        for(int num : nums)
            set.add(num);

        for(int i = 0; i<nums.length; i++){
            int number = nums[i];
            int count = 1;

            while(set.contains(--number)){
                count++;
                set.remove(number);
            }

            number = nums[i];

            while(set.contains(++number)){
                count++;
                set.remove(number);
            }

            if(max < count){
                max = count;
            }

        }
        return max;
    }
}
