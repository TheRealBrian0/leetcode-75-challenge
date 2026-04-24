/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int globalmax = 0;
    public int longestZigZag(TreeNode root) {
        traverse(root.left, 1, true);
        traverse(root.right, 1, false);
        return globalmax;
    }
    public void traverse(TreeNode root, int stepCount, boolean isLeft){
        if (root == null) return;
        globalmax = Math.max(globalmax, stepCount);
        if (isLeft) {
            // We just moved Left to get here
            traverse(root.right, stepCount + 1, false); // continue zigzag
            traverse(root.left, 1, true);               // start new streak
        } else {
            // We just moved Right to get here
            traverse(root.left, stepCount + 1, true);   // continue zigzag
            traverse(root.right, 1, false);             // start new streak
        }
    }
}