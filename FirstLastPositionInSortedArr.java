class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirstPosition(nums, target);
        result[1] = findLastPosition(nums, target);
        return result;
    }

    private int findFirstPosition(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int firstPosition = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                firstPosition = mid;
                high = mid - 1; // Keep searching to the left
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return firstPosition;
    }

    private int findLastPosition(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int lastPosition = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                lastPosition = mid;
                low = mid + 1; // Keep searching to the right
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return lastPosition;
    }
}
