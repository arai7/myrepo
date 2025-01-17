class Solution 
{
    public boolean canJump(int[] nums)
    {
        int length = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(i > length)
                return false;
            length = Math.max(length, i+nums[i]);
        }
        return true;
    }
}
