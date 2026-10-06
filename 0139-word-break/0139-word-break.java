class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //top-down approach
        boolean[] dp = new boolean[s.length()+1];
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = false;
        }

        //bottom most best case scenario
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (String w : wordDict) {
                int len = w.length();

                // 1. Is the current prefix at least as long as word 'w'?
                // (i.e., does i >= len?)

                // 2. If it is, what are the start and end indices of the substring to compare with 'w'?

                // 3. What must be true about the state BEFORE this word (dp[i - len]) 
                //    AND the substring itself?
                if(i >= len){
                    if(dp[i-len] ==true && s.substring(i-len,i).equals(w)){
                        dp[i] = true;
                        break;
                    }
                    
                }
            }
        }
        return dp[s.length()];
    }
}