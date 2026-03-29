class Solution {
    public String mergeAlternately(String w1, String w2) {
        StringBuilder out = new StringBuilder();
        //largest size
        int n = w1.length() >= w2.length() ? w1.length() : w2.length();

        for(int i=0; i<n; i++){
            if(i<w1.length()){
                out.append(w1.charAt(i));
            }

            if(i<w2.length()){
                out.append(w2.charAt(i));
            }
        }

        return out.toString();
    }
}