import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        // End word must be in the word set
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<Map.Entry<String, Integer>> queue = new LinkedList<>();
        queue.offer(new AbstractMap.SimpleEntry<>(beginWord, 1));

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            Map.Entry<String, Integer> pair = queue.poll();
            String currentWord = pair.getKey();
            int stepSoFar = pair.getValue();

            if (currentWord.equals(endWord)) {
                return stepSoFar;
            }

            for (int i = 0; i < currentWord.length(); i++) {
                char[] wordArray = currentWord.toCharArray();

                for (char c = 'a'; c <= 'z'; c++) {
                    if (wordArray[i] == c) continue;

                    wordArray[i] = c;
                    String newWord = new String(wordArray);

                    if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                        queue.offer(new AbstractMap.SimpleEntry<>(newWord, stepSoFar + 1));
                        visited.add(newWord);
                    }
                }
            }
        }

        return 0; // No transformation found
    }
}
