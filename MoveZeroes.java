class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;  // Pointer to track the position of the next non-zero element
        
        // Pass 1: Move non-zero elements forward
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[count++] = nums[i]; // Move non-zero element to the 'count' index
            }
        }
        
        // Pass 2: Fill the rest of the array with zeros
        while (count < nums.length) {
            nums[count++] = 0;
        }
    }
}
