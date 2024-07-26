class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;
        Map<Character, String> charToWord = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            if (!charToWord.containsKey(c)) {
                if (charToWord.containsValue(word)) return false;
                charToWord.put(c, word);
            }
            else if (!charToWord.get(c).equals(word)) return false;
        }
        return true;
    }
}
