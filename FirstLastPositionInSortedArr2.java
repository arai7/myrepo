class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lowerBound = findLowerBound(nums, target);
        int upperBound = findUpperBound(nums, target);

        int[] result = new int[2];
        result[0] = lowerBound;
        result[1] = upperBound;

        return result;
    }

    public int findLowerBound(int[] nums, int target){
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while(left<right){
            int mid = (left + right) / 2;

            if(nums[mid] > target){
                right = mid - 1;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }

    public int findUpperBound(int[] nums, int target){
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while(left<right){
            int mid = ((left + right) / 2) + 1;

            if(nums[mid] > target){
                right = mid - 1;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                left = mid;
            }
        }
        return nums[right] == target ? right : -1;
    }
}
