/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //check if i am p or q, if yes, im the ancestor
        if(root==null || root==p || root==q){
            return root;
        }

        //move left and right
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        //if both side not p or q, then i am the root, restart from me
        if(right!=null && left!=null){
            return root;
        }

        //if only left or only right is null, restart from non-null root
        if(left!=null){
            return left;
        }else{
            return right;
        }

    }
}