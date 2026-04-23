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
    //VISUALISE HERE FOR BETTER UNDERSTANDING; FUTURE REF
    //https://pythontutor.com/visualize.html#mode=display
    public int goodNodes(TreeNode root) {
        return traverse(root, root.val);
    }
    public int traverse(TreeNode root, int maxSoFar){
        int count = 0;
        if(root==null){return 0;}
        if(root.val >= maxSoFar){
            count++;
        }
        int newMax = Math.max(root.val,maxSoFar);
        return (count + traverse(root.left, newMax) + traverse(root.right, newMax));
    }
}