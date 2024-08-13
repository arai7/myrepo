class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1}; // Convert to 1-based index
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        // The problem guarantees exactly one solution, so we don't need to handle the case where no solution exists.
        return new int[]{-1, -1}; // This line should never be reached.
    }
}
