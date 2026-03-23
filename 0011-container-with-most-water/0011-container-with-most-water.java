class Solution {
    public int maxArea(int[] height) {
        if(height.length==0 || height.length==1){
            return 0;
        }
        int i=0; int j=height.length-1;
        int maxv = 0;
        while( j > i){
            maxv = Math.max(maxv,(j-i)*(Math.min(height[i],height[j])));
            if(height[i]<height[j]){i++;}
            else{j--;}
        }
        return maxv;
    }
}