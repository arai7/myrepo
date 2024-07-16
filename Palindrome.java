class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");

        char start;
        char end;

        for(int i = 0; i < s.length(); i++){
            start = s.charAt(i);
            end  = s.charAt(s.length()-1-i);
            if(start != end){
                return false;
            }
        }

        return true;
    }
}
