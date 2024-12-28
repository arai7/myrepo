class Solution {
    public boolean increasingTriplet(int[] nums) {
        // Initialize the first and second variables to maximum possible values
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

        // Traverse the array
        for (int num : nums) {
            if (num <= first) {
                // Update 'first' if the current number is smaller or equal
                first = num;
            } else if (num <= second) {
                // Update 'second' if the current number is larger than 'first' but smaller or equal to 'second'
                second = num;
            } else {
                // If we find a number larger than 'second', we have an increasing triplet
                return true;
            }
        }

        // If we traverse the entire array without finding a triplet, return false
        return false;
    }
}
