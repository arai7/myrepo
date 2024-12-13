class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length())
            return false;

        // Frequency arrays for s1 and the current window in s2
        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        // Fill frequency array for s1
        for (char ch : s1.toCharArray()) {
            s1Freq[ch - 'a']++;
        }

        // Sliding window
        int windowLength = s1.length();
        for (int i = 0; i < s2.length(); i++) {
            // Add the current character to the window frequency
            windowFreq[s2.charAt(i) - 'a']++;

            // Remove the character that is sliding out of the window
            if (i >= windowLength) {
                windowFreq[s2.charAt(i - windowLength) - 'a']--;
            }

            // Compare frequency arrays
            if (areArraysEqual(s1Freq, windowFreq)) {
                return true;
            }
        }

        return false;
    }

    // Helper method to compare two frequency arrays
    private boolean areArraysEqual(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
