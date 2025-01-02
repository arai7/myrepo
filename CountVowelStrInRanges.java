class Solution 
{
    public int[] vowelStrings(String[] words, int[][] queries) 
    {
        int n = words.length;
        int prevSum = 0;
        int[] prefixSum = new int[n];

        for(int i = 0 ; i < n ; i++)
        {
            if (isVowelWord(words[i]))
            {
                prevSum++;
                prefixSum[i] = prevSum;
            }
            else
            {
                prefixSum[i] = prevSum;
            }
        }

        int num = queries.length;
        int[] res = new int[num];

        for(int i = 0; i < num ; i++)
        {
            int startIdx = queries[i][0];
            int endIdx = queries[i][1];
            res[i] = (startIdx == 0) ? prefixSum[endIdx] : prefixSum[endIdx] - prefixSum[startIdx - 1];

        }

        return res;
    }

    private boolean isVowelWord(String word) 
    {
        char start = word.charAt(0);
        char end = word.charAt(word.length() - 1);
        return isVowel(start) && isVowel(end);
    }

    private boolean isVowel(char c) 
    {
        return "aeiou".indexOf(c) != -1;
    }
}
