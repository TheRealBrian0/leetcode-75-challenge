class Solution {
    public int equalPairs(int[][] grid) {
        //build the map
        HashMap <List<Integer>, Integer> map = new HashMap<>();
        //iterate rows
        for(int row[]:grid){
            //create row list here
            List<Integer> rowlist = new ArrayList<>();
            for(int i=0; i<row.length; i++){
                rowlist.add(row[i]);
            }
            map.put(rowlist, map.getOrDefault(rowlist,0)+1);
        }
        int count = 0;
        //iterate columns
        for(int row=0; row<grid.length; row++){
            List<Integer> collist = new ArrayList<>();
            for(int col=0; col<grid[row].length; col++){
                //notice the swapped indices, we want only the col
                collist.add(grid[col][row]);
            }
            if(map.containsKey(collist)){
                count = count + map.get(collist);
            }
        }
        return count;
    }
}