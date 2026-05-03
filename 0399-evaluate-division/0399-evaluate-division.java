class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 1. Build the Graph
        Map<String, Map<String, Double>> adj = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];
            
            adj.computeIfAbsent(u, k -> new HashMap<>()).put(v, val);
            adj.computeIfAbsent(v, k -> new HashMap<>()).put(u, 1.0 / val);
        }

        // 2. Process each query
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            
            if (!adj.containsKey(start) || !adj.containsKey(end)) {
                results[i] = -1.0;
            } else if (start.equals(end)) {
                results[i] = 1.0;
            } else {
                results[i] = dfs(start, end, 1.0, adj, new HashSet<>());
            }
        }
        return results;
    }

    private double dfs(String curr, String target, double product, 
                       Map<String, Map<String, Double>> adj, Set<String> visited) {
        visited.add(curr);
        Map<String, Double> neighbors = adj.get(curr);
        
        // If target is a direct neighbor, we're done!
        if (neighbors.containsKey(target)) {
            return product * neighbors.get(target);
        }

        // Otherwise, explore neighbors recursively
        for (String next : neighbors.keySet()) {
            if (!visited.contains(next)) {
                double result = dfs(next, target, product * neighbors.get(next), adj, visited);
                if (result != -1.0) return result;
            }
        }

        return -1.0; // Path not found
    }
}