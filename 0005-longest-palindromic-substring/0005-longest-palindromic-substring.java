class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int[] odd = helper(i, i, s);
            int oddLen = odd[1] - odd[0];
            if (oddLen > maxLen) {
                maxLen = oddLen;
                start = odd[0];
            }

            int[] even = helper(i, i + 1, s);
            int evenLen = even[1] - even[0];
            if (evenLen > maxLen) {
                maxLen = evenLen;
                start = even[0];
            }
        }

        return s.substring(start, start + maxLen);
    }

        public int[] helper(int left, int right, String s) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            // left + 1 is the true start
            // right is already the exclusive end index for s.substring(start, end)
            return new int[]{left + 1, right};
        }
}