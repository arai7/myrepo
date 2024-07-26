class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        String[] splited = s.split(" ");
        String lastStr = splited[splited.length-1];
        return lastStr.length();
    }
}
