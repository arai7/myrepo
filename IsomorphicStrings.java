class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] map_s = new int[128];
        int[] map_t = new int[128];
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            if (map_s[s.charAt(i)] != map_t[t.charAt(i)])
                return false;
            map_s[s.charAt(i)] = i + 1;
            map_t[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
