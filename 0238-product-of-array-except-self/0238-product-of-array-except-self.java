class Solution {
    public int[] productExceptSelf(int[] nums) {
        //calc the left prefix
        int[] out = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(i==0){
                left[i]=1;
                continue;
            }
            left[i] = left[i-1] * nums[i-1];
        }
        //calc the right prefix
        for(int i=nums.length-1; i>=0; i--){
            if(i==nums.length-1){
                right[i]=1;
                continue;
            }
            right[i]=right[i+1] * nums[i+1];
        }

        //combining the two
        for(int i=0; i<nums.length; i++){
            out[i] = left[i] * right[i];
        }
        // System.out.println(left);
        // System.out.println(right);
        return out;
    }
}