class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = Stream.of('a','e','i','o','u').collect(Collectors.toSet());     
        int count = 0;   
        //first 'k' elements
        for(int i=0; i<k; i++){
            if(vowels.contains(s.charAt(i))){
                count++;
            }
        }
        int i = k;
        int maxl = count;
        while(i<s.length()){
            if(vowels.contains(s.charAt(i-k))){
                //if 'leaving' element is a vowel, subtract count
                count--;
            }
            if(vowels.contains(s.charAt(i))){
                //if 'entering' element is a vowel, add to count
                count++;
            }
            maxl = Math.max(count,maxl);
            i++;
        }
        return maxl;
    }
}