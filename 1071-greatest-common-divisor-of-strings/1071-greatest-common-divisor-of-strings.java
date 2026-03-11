class Solution {
    public int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }
        int L = str1.length() > str2.length() ? gcd(str2.length(),str1.length()) : gcd(str1.length(),str2.length());

        // for(int i=0; i<str1.length(); i=i+L){
        //     if(!(str1.substring(i,i+L)).equals(str2.substring(0,i+L))){
        //         // System.out.println(str1.substring(i,L));
        //         return "";
        //     }
        // }
        return str2.substring(0,L);
    }
}