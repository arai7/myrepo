class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        // Base case: if the current combination is complete
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }

        // Add an opening parenthesis if possible
        if (open < max) {
            current.append('(');
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1); // undo the last action (backtrack)
        }

        // Add a closing parenthesis if possible
        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1); // undo the last action (backtrack)
        }
    }
}
