class Solution {
    public int minReorder(int n, int[][] connections) {
        // 1. Build the Adjacency List with "Costs"
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] c : connections) {
            // Real road: From c[0] to c[1]. If we follow this from 0, it's a flip!
            adj.get(c[0]).add(new int[]{c[1], 1}); 
            // Fake road: To allow us to traverse the whole tree
            adj.get(c[1]).add(new int[]{c[0], 0}); 
        }

        // 2. Standard BFS
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.offer(0);
        visited[0] = true;
        
        int totalFlips = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int[] neighbor : adj.get(curr)) {
                int nextNode = neighbor[0];
                int cost = neighbor[1];

                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    totalFlips += cost; // Add 1 if it's a real road pointing away
                    q.offer(nextNode);
                }
            }
        }

        return totalFlips;
    }
}