class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        if(!s.contains(" ")){
            return s;
        }
        String[] words = s.split(" ");
        String reversedStr = "";

        for(int i = words.length-1; i >=0 ; i--){
            if(words[i].isEmpty()){
                continue;
            }
            reversedStr = reversedStr+" "+words[i];
        }
        reversedStr = reversedStr.trim();
        return reversedStr;
    }
}
