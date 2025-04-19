import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int steps = 1;

        while (!queue.isEmpty()) {
            int size = queue.size(); // Track level size for BFS

            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                if (word.equals(endWord)) return steps;

                for (String neighbor : getOneLetterNeighbors(word, wordSet)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }

            steps++;
        }

        return 0; // No valid transformation
    }

    private List<String> getOneLetterNeighbors(String word, Set<String> wordSet) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char original = chars[i];

            for (char c = 'a'; c <= 'z'; c++) {
                if (c == original) continue;

                chars[i] = c;
                String newWord = new String(chars);

                if (wordSet.contains(newWord)) {
                    neighbors.add(newWord);
                }
            }

            chars[i] = original; // Restore original character
        }

        return neighbors;
    }
}
