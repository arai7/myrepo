class Solution {
    public int maximumSum(int[] nums) {
        // Map to store the two largest numbers for each digit sum
        HashMap<Integer, int[]> map = new HashMap<>();
        int maxSum = -1;
        
        for (int num : nums) {
            int digitSum = getDigitSum(num);
            
            if (!map.containsKey(digitSum)) {
                // First number with this digit sum
                map.put(digitSum, new int[]{num, 0});
            } else {
                // We already have number(s) with this digit sum
                int[] values = map.get(digitSum);
                if (num > values[0]) {
                    // New number is largest
                    values[1] = values[0];
                    values[0] = num;
                    maxSum = Math.max(maxSum, values[0] + values[1]);
                } else if (num > values[1]) {
                    // New number is second largest
                    values[1] = num;
                    maxSum = Math.max(maxSum, values[0] + values[1]);
                }
            }
        }
        
        return maxSum;
    }
    
    private int getDigitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
