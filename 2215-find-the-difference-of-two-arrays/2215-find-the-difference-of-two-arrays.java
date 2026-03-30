class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> out = new ArrayList<>();
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();
        //initialise arraylist inside the arraylist
        out.add(new ArrayList<Integer>());
        out.add(new ArrayList<>());
        for(int i=0; i<nums1.length; i++){
            s1.add(nums1[i]);
            s2.add(nums2[i]);
        }
        for(int a:s1){
            if(!s2.contains(a)){
                out.get(0).add(a);
            }
        }
        for(int b:s2){
            if(!s1.contains(b)){
                out.get(1).add(b);
            }
        }
        return out;
    }
}