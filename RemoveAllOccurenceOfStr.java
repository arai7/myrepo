class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        
        while (sb.indexOf(part) != -1) {  // While 'part' exists in sb
            int index = sb.indexOf(part);
            sb.delete(index, index + part.length());  // Remove the first occurrence
        }
        
        return sb.toString();
    }
}
