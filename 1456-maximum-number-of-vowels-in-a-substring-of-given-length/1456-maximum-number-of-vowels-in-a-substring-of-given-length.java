class Solution {
    public boolean vowel(char c){
        return c=='a' || c=='e' || c=='i' || c=='o'|| c=='u';
    }
    public int maxVowels(String s, int k) {
        // Set<Character> vowels = Stream.of('a','e','i','o','u').collect(Collectors.toSet());     
        int count = 0;   
        //first 'k' elements
        for(int i=0; i<k; i++){
            if(vowel(s.charAt(i))){
                count++;
            }
        }
        int i = k;
        int maxl = count;
        while(i<s.length()){
            if(vowel(s.charAt(i-k))){
                //if 'leaving' element is a vowel, subtract count
                count--;
            }
            if(vowel(s.charAt(i))){
                //if 'entering' element is a vowel, add to count
                count++;
            }
            maxl = Math.max(count,maxl);
            i++;
        }
        return maxl;
    }
}