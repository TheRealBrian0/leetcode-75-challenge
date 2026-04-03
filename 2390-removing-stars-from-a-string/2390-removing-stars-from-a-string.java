class Solution {
    public String removeStars(String s) {
        StringBuilder str = new StringBuilder();
        int i=0;
        // int j=i-1;
        for(i=0; i<s.length(); i++){
            if(s.charAt(i)!='*'){
                // j++;
                str.append(s.charAt(i));
            }else{
                if(str.length()>0){ //only if there are elements to delete
                    //no need of j pointer, StringBuilder can call its own length and remove last known char
                    str.deleteCharAt(str.length()-1);
                }
                // j--;
                continue;
            }

        }
        return str.toString();
    }
}