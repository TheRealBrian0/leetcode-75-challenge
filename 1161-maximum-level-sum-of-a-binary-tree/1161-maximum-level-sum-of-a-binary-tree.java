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
    public int maxLevelSum(TreeNode root) {
        int maxVal = Integer.MIN_VALUE;
        int sum = 0;
        int level = 0;
        int maxLevel = 1;
        Deque<TreeNode> dq = new ArrayDeque<>();
        if(root == null){return 0;}
        dq.offer(root);
        while(!dq.isEmpty()){
            int size = dq.size();
            level++;

            for(int i=0; i<size; i++){
                //increment when we start a new level
                TreeNode curr = dq.poll();
                sum = sum + curr.val;
                if(curr.left!=null){
                    dq.offer(curr.left);
                }
                if(curr.right!=null){
                    dq.offer(curr.right);
                }
            }

            if(maxVal < sum){
                maxLevel = level;
            }
            maxVal = Math.max(maxVal,sum);
            sum=0;

        }
        return maxLevel;

    }
}