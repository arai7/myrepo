//SOLUTION 1
class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        if(s.length() != t.length())
            return false;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, 1);
            }else{
                int val = map.get(c);
                map.put(c, val+1);
            }
            
        }
        int count = 0;
        while(count < s.length()){
            char c = t.charAt(count);
            if(map.containsKey(c)){
                count++;
                int val = map.get(c);
                val = val-1;
                if(val == 0){
                    map.remove(c);
                }else{
                    map.put(c, val);
                }
            }
            else{
                return false;
            }
        }
        return true;
    }
}

//SOLUTION 2
class Solution {
    public boolean isAnagram(String s, String t) {
        int n1 = s.length(); 
        int n2 = t.length(); 
  
        // If length of both strings is not same, 
        // then they cannot be anagram 
        if (n1 != n2) 
            return false; 
  
        // Sort both strings 
        char tempArray1[] = s.toCharArray(); 
        char tempArray2[] = t.toCharArray(); 
        Arrays.sort(tempArray1); 
        Arrays.sort(tempArray2); 
  
        // Compare sorted strings 
        for (int i = 0; i < n1; i++) 
            if (tempArray1[i] != tempArray2[i]) 
                return false; 
  
        return true; 
    }
}
