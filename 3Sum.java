class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Sort the array
        
        for (int i = 0; i < nums.length - 2; i++) 
        {
            if (i > 0 && nums[i] == nums[i - 1]) 
                continue;  // Skip duplicates for the first element

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) 
            {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) 
                {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move the left pointer past duplicates
                    while (left < right && nums[left] == nums[left + 1]) 
                        left++;
                    // Move the right pointer past duplicates
                    while (left < right && nums[right] == nums[right - 1]) 
                        right--;

                    left++;
                    right--;
                } 
                else if (sum < 0) 
                {
                    left++;  // Increase the sum
                } 
                else 
                {
                    right--;  // Decrease the sum
                }
            }
        }
        
        return result;
    }
}
