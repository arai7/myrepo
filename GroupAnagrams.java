import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map to store sorted string as key and list of anagrams as value
        HashMap<String, List<String>> hashMap = new HashMap<>();
        
        for (String str : strs) {
            String sortedStr = sortedString(str);
            
            // Check if the sorted string is already a key in the map
            if (!hashMap.containsKey(sortedStr)) {
                // If not, create a new list and add it to the map
                hashMap.put(sortedStr, new ArrayList<>(Arrays.asList(str)));
            } else {
                // If yes, add the current string to the existing list
                hashMap.get(sortedStr).add(str);
            }
        }
        
        // Collect all anagram groups as a list of lists
        List<List<String>> groupedStrings = new ArrayList<>(hashMap.values());
        return groupedStrings;
    }

    private String sortedString(String str) {
        char[] chars = str.toCharArray();   // Convert string to char array
        Arrays.sort(chars);                 // Sort the char array
        return new String(chars);           // Convert back to string
    }
}
