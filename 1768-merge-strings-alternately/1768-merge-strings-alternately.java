class Solution {
    public String mergeAlternately(String w1, String w2) {
        StringBuilder output = new StringBuilder();
        // StringBuilder w1 = new StringBuilder(word1);
        // StringBuilder w2 = new StringBuilder(word2);
        int n = w1.length() >= w2.length() ? w1.length() : w2.length();
        for(int i=0;i<n;i++){
            if(i<w1.length()){
                output.append(w1.charAt(i));
            }else{
                output.append(w2.substring(i));
                break;
            }
            if(i<w2.length()){
                output.append(w2.charAt(i));
            }else{
                output.append(w1.substring(i+1));
                break;
            }
        }
        return output.toString();
    }
}