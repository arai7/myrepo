class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); // Stores indices of temperatures
        
        for (int i = 0; i < n; i++) {
            // While the stack is not empty and the current temperature is higher
            // than the temperature at the index stored at the top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop(); // Get the index of the colder day
                result[prevIndex] = i - prevIndex; // Calculate the number of days
            }
            stack.push(i); // Push the current index onto the stack
        }
        
        return result; // Remaining indices in stack will automatically have 0 in result
    }
}
