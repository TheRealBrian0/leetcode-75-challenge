class Solution {
    public int compress(char[] chars) {
        int r=0;int s=0;int w=0;
        while(r<chars.length){
            while(r<chars.length && chars[s]==chars[r]){
                r++;
            }
            int count=r - s;
            chars[w] = chars[s];
            w++;
            if(count>1){
                for(char c : String.valueOf(count).toCharArray()){
                    chars[w] = c;
                    w++;
                }
            }
            //reset 's'
            s = r;
        }
        return w;
    }
}