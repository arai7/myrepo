public class MinSizeSubarraySum {

    public static int minSizeSubarraySum(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException("array is null"); 
        }
        int len = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;

        while(right < len){
            sum += nums[right];
            
            while(sum >= target){
                res = Math.min(res, right - left + 1);
                sum -= nums[left++];
            }

            right++;           
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        runTest(new int[]{2, 3, 1, 2, 4, 3},     7,   2);
        runTest(new int[]{1, 4, 4},              4,   1);
        runTest(new int[]{1, 1, 1, 1, 1, 1},    11,   0);
        runTest(new int[]{1, 2, 3, 4, 5},       11,   3);
        runTest(new int[]{10},                   5,   1);
        runTest(new int[]{1, 2, 3},            100,   0);
        runTest(new int[]{1, 2, 3, 4, 5},       15,   5);
        runTest(new int[]{},                     5,   0);
        runTestThrows(null,                      5);
    }

    private static void runTest(int[] nums, int target, int expected) {
        int actual = minSizeSubarraySum(nums, target);
        String status = (actual == expected) ? "PASS" : "FAIL";
        System.out.println(status + " — target=" + target + " expected=" + expected + " actual=" + actual);
    }

    private static void runTestThrows(int[] nums, int target) {
        try {
            int actual = minSizeSubarraySum(nums, target);
            System.out.println("FAIL — target=" + target + " expected=throw actual=" + actual);
        } catch (IllegalArgumentException e) {
            System.out.println("PASS — target=" + target + " expected=throw actual=throw (" + e.getMessage() + ")");
        }
    }
}
