class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        Set<Integer> setValueCount = new HashSet<>(map.values());
        Set<Integer> setKeyCount = new HashSet<>(map.keySet());
        if(setValueCount.size() == setKeyCount.size()){
            return true;
        }
        return false;

    }
}