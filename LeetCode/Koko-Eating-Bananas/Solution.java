1class Solution {
2    public int minEatingSpeed(int[] piles, int h) {
3        //can be between 1 and max(piles);
4        int l = 1;
5        //find max;
6        int r = 0;
7        for(int i=0; i<piles.length; i++){
8            r = Math.max(piles[i],r);
9        }
10
11        while(l<r){
12            int mid = l + (r - l)/2;
13            if(checker(piles,h,mid)){
14                //maybe go slower, move towards speed being 1;
15                r = mid;
16            }else{
17                //if false, too fast, mowards speed being max(piles)
18                l = mid+1;
19            }
20        }
21        return l;
22
23    }
24    public boolean checker(int[] piles, int h, int k){
25        int hours=0;
26        for(int i=0; i<piles.length; i++){
27            hours = hours + (piles[i] + k - 1)/k; //do this to instead of ceil to not lose round off value
28        }
29        if(hours<=h){
30            return true;
31        }
32        return false;
33    }
34}