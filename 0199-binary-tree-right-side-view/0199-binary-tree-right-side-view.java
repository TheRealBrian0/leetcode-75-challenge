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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        if(root == null){return res;}
        dq.offer(root);
        while(!dq.isEmpty()){
            //take size;
            int size = dq.size();

            //iterate until empty
            for(int i=0; i<size; i++){
                //remove the curr node
                TreeNode curr = dq.poll();

                //last with the right side node
                if(i==size-1){
                    res.add(curr.val);
                }

                if(curr.left!=null){
                    dq.offer(curr.left);
                }
                if(curr.right!=null){
                    dq.offer(curr.right);
                }
            }
        }
        return res;
    }
}