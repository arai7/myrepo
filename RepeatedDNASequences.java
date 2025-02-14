import java.util.*;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seenSet = new HashSet<>();
        Set<String> resultSet = new HashSet<>();
        
        int n = s.length();
        for (int i = 0; i <= n - 10; i++) {
            String substring = s.substring(i, i + 10);
            if (seenSet.contains(substring)) {
                resultSet.add(substring); // Add to result if seen before
            }
            seenSet.add(substring);
        }
        
        return new ArrayList<>(resultSet);
    }
}
