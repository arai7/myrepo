class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Boolean isPresent = true;
        Map<Character, Integer> originalMap = new HashMap<>();
        char[] mag_string = magazine.toCharArray();
        //char[] mag_string = magazine.split("");
        for(int i=0; i<mag_string.length; i++){
            if(originalMap.get(mag_string[i]) != null){
                int k = originalMap.get(mag_string[i]);
                originalMap.put(mag_string[i], ++k);
            }
            else{
               originalMap.put(mag_string[i], 1); 
            }
        }

        char[] ransomArray = ransomNote.toCharArray();
        for(int i=0; i< ransomNote.length(); i++){
            //System.out.println("ransomArray[i] is "+ransomArray[i]);
            //System.out.println("originalMap.containsKey is "+originalMap.containsKey(ransomArray[i]));
            
            if(originalMap.containsKey(ransomArray[i])){
                int k = originalMap.get(ransomArray[i]);
                if(k==1){
                    originalMap.remove(ransomArray[i]);
                }
                else{
                    //System.out.println("k is "+k);
                    originalMap.put(ransomArray[i], --k);
                }
            }
            else{
                isPresent = false;
                break;
            }
        }
        return isPresent;
    }
}
