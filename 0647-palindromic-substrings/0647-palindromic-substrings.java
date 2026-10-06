class Solution {
    public int countSubstrings(String s) {
        int count = s.length();
        int oddeven = count;
        if(count==0){
            return 0;
        }else if(count==1){
            return 1;
        }
        // StringBuilder str = new StringBuilder(s);
        for(int i=0; i<s.length(); i++){
            //if odd centre
            int v1 = helper(i, s);
            int v2 = helper(i, i+1, s);
            count = count + v1 + v2;
        }
        return count;
        
    }

    public int helper(int i, String s){
        int temp=0;
        int left=i-1;
        int right = i+1;
        while((left>=0 && right<s.length()) && s.charAt(left)==s.charAt(right)){
            temp+=1;
            left--;
            right++;
        }
        return temp;
    }
    public int helper(int i, int j, String s){
        int temp=0;
        int left=i;
        int right = j;
        while((left>=0 && right<s.length()) && s.charAt(left)==s.charAt(right)){
            temp+=1;
            left--;
            right++;
        }
        return temp;
    }

}