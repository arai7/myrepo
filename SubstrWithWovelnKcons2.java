import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long countOfSubstrings(String word, int k) {
        return countSubstringsWithAtLeastKConsonants(word, k) - countSubstringsWithAtLeastKConsonants(word, k + 1);
    }

    private long countSubstringsWithAtLeastKConsonants(String word, int k) {
        long count = 0;
        int left = 0, consonantCount = 0;
        Map<Character, Integer> vowelMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            if (isVowel(c)) {
                vowelMap.put(c, vowelMap.getOrDefault(c, 0) + 1);
            } else {
                consonantCount++;
            }
            while (consonantCount >= k && vowelMap.size() == 5) {
                char leftChar = word.charAt(left++);
                if (isVowel(leftChar)) {
                    vowelMap.put(leftChar, vowelMap.get(leftChar) - 1);
                    if (vowelMap.get(leftChar) == 0) {
                        vowelMap.remove(leftChar);
                    }
                } else {
                    consonantCount--;
                }
            }
            count += left;
        }
        return count;
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}
