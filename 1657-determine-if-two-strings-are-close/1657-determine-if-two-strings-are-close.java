import java.util.Arrays;

//NOT MY SOLUTION
class Solution {
    public boolean closeStrings(String word1, String word2) {
        // Law 0: Lengths must match
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Fill frequency arrays
        // can use advanced loop but slower
        //for(char c: word1.toCharArray()) {---}
        for (int i = 0; i < word1.length(); i++) {
            char c = word1.charAt(i);
            freq1[c - 'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            char c = word2.charAt(i);
            freq2[c - 'a']++;
        }

        // Law 1: The Law of Existence (The "Alphabet" Check)
        // If a character exists in one, it MUST exist in the other.
        // We check this BEFORE sorting.
        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0)) {
                return false;
            }
        }

        // Law 2: The Law of Frequency Patterns (The "Count" Check)
        // Operation 2 lets us trade the "identities" of counts.
        // So the sorted list of frequencies must be identical.
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        // If the sorted counts match, we can transform word1 into word2!
        return Arrays.equals(freq1, freq2);
    }
}