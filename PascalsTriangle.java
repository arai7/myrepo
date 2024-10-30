class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1); // First element is always 1
            
            // Calculate middle elements based on the previous row
            for (int j = 1; j < i; j++) {
                int sum = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                row.add(sum);
            }
            
            if (i > 0) {
                row.add(1); // Last element is also 1 for rows beyond the first
            }
            
            triangle.add(row);
        }
        
        return triangle;
    }
}
