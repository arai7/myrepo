class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<int[]> stack = new Stack<>(); // Stores pairs of (temperature, index)
        
        // Process from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Remove all colder days from the stack
            while (!stack.isEmpty() && stack.peek()[0] <= temperatures[i]) {
                stack.pop();
            }
            // If stack is not empty, calculate the difference in indices
            result[i] = stack.isEmpty() ? 0 : stack.peek()[1] - i;
            // Push the current temperature and its index onto the stack
            stack.push(new int[]{temperatures[i], i});
        }
        
        return result;
    }
}
