class Solution {
    public int characterReplacement(String s, int k) {
        int winStart = 0;
        int maxLen = 0;
        int maxFreq = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        for(int winEnd = 0; winEnd < s.length(); winEnd++){
            char currentChar = s.charAt(winEnd);
            freqMap.put(currentChar, freqMap.getOrDefault(currentChar, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(currentChar));
            int currWinLen = winEnd - winStart + 1;
            if(currWinLen - maxFreq <= k){
                maxLen++;
            }
            else{
                char leftChar = s.charAt(winStart);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                winStart++;
            }
        }
        return maxLen;
    }
}
