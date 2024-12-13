class Solution 
{
    public boolean checkInclusion(String s1, String s2) 
    {
        if(s2.length()<s1.length())
            return false;
        HashMap<Character, Integer> map1 = new HashMap<>();
        map1 = createMap(s1);

        int windowLength = s1.length();
        int left = 0;
        int right = windowLength - 1;

        char[] charArray = s2.toCharArray();
        while(right < s2.length())
        {
            String sub = s2.substring(left, right+1);
            HashMap<Character, Integer> map2 = createMap(sub);
            if(map1.equals(map2))
                return true;
            
            left+=1;
            right+=1;
        }
        return false;
    }
    public HashMap createMap(String str)
    {
        HashMap<Character, Integer> map1 = new HashMap<>();
        int length = str.length();
        char[] charArray = str.toCharArray();

        for (char ch : charArray) 
        {
            if(!map1.containsKey(ch))
            {
                map1.put(ch, 1);
            }
            else
            {
                int n = map1.get(ch);
                map1.put(ch, n+1);
            }
        }
        return map1;
    }
}
