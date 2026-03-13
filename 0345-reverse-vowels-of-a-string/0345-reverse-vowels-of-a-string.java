class Solution {
    public String reverseVowels(String s) {
        String vowel = "aeiouAEIOU";
        int i=0;
        int j=s.length()-1;
        StringBuilder str = new StringBuilder(s);
        while(j>i){
            if(vowel.indexOf(str.charAt(j))!=-1 && j>i){ //vowel exists
                while(vowel.indexOf(str.charAt(i))==-1){
                    i++;
                }
                char c = str.charAt(i);
                str.setCharAt(i,str.charAt(j));
                str.setCharAt(j,c);
                i++;
            } 
            j--;
        }
        return str.toString();
    }
}