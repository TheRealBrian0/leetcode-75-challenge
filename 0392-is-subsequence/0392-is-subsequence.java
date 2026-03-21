class Solution {
    public boolean isSubsequence(String s, String t) {
        int r=0;
        if(s.isEmpty()){return true;}
        for(char c: t.toCharArray()){
            if(s.charAt(r) == c){
                r++;
                if(r==s.length()){
                return true;
                }
            }
        }
        return false;
    }
}