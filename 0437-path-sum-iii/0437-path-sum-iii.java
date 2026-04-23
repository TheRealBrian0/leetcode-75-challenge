//AI Solution, retry again sometime

class Solution {
    // THE MANAGER: Walks to every node in the tree to pick a "starting point"
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        
        // 1. Tell the Scout to start exactly here
        int pathsStartingHere = countFrom(root, (long)targetSum);
        
        // 2. Move the Manager to the left child to try starting there
        int pathsInLeftSubtree = pathSum(root.left, targetSum);
        
        // 3. Move the Manager to the right child to try starting there
        int pathsInRightSubtree = pathSum(root.right, targetSum);
        
        return pathsStartingHere + pathsInLeftSubtree + pathsInRightSubtree;
    }

    // THE SCOUT: Starts at a specific node and "dives" down to find sums
    private int countFrom(TreeNode node, long remainingSum) {
        if (node == null) return 0;
        
        int count = 0;
        // If the current node itself completes the sum, we found 1!
        if (node.val == remainingSum) {
            count = 1;
        }
        
        // We MUST keep going even if we found a path (count = 1), 
        // because a path of [8, 5, -5] also sums to 8!
        count += countFrom(node.left, remainingSum - node.val);
        count += countFrom(node.right, remainingSum - node.val);
        
        return count;
    }
}