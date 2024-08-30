class Solution {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int remaining, int start) {
        if (remaining < 0) {
            return; // Exceeded the target, stop further exploration.
        }
        if (remaining == 0) {
            result.add(new ArrayList<>(current)); // Found a valid combination, add it to the result.
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrack(result, current, candidates, remaining - candidates[i], i); // Not i + 1 because we can reuse the same elements.
            current.remove(current.size() - 1); // Backtrack by removing the last element.
        }
    }
}
