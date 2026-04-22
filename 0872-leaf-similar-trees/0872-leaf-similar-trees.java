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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        traverse1(root1,arr1);
        traverse2(root2,arr2);
        if(arr1.equals(arr2)){
            return true;
        }
        return false;
    }
    //USE POLYMORPHISM YOU IDIOT
    public void traverse1(TreeNode root1, List<Integer> arr1){
        if(root1 == null){return;}
        traverse1(root1.left,arr1);
        if(root1.left==null && root1.right==null){
            arr1.add(root1.val);
        }
        traverse1(root1.right,arr1);
    }

    public void traverse2(TreeNode root2, List<Integer> arr2){
        if(root2 == null){return;}
        traverse2(root2.left,arr2);
        if(root2.left==null && root2.right==null){
            arr2.add(root2.val);
        }
        traverse2(root2.right,arr2);
    }
}