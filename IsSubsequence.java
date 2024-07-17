class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.isEmpty())
            return true;
        
        if(s.length()==0 || t.length()==0){
            return false;
        }

        int j = 0;

        for(int i = 0; i < t.length() ; i++){
            //System.out.println("s charAt "+s.charAt(j));
            //System.out.println("t charAt "+t.charAt(i));
            if(s.charAt(j) == t.charAt(i)){
                //System.out.println("plus plus j");
                j++;
                if(j>=s.length())
                    break;
            }
        }
        //System.out.println("j final "+j);
        if(j == s.length())
            return true;

        return false;
    }
}
