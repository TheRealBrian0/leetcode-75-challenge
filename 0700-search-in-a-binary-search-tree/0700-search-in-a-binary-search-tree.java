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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){return null;}
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        while(!dq.isEmpty()){
            int size = dq.size();
            for(int i=0; i<size; i++){
                TreeNode curr = dq.poll();

                if(curr.val == val){
                    return curr;
                }

                if(curr.left!=null){
                    dq.offer(curr.left);
                }
                if(curr.right!=null){
                    dq.offer(curr.right);
                }
            }            
        }
        return null;
    }
}