//AI solution, try again

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // 1. Navigate the tree to find the node
        if (key < root.val) {
            // "Hey left child, delete the key and tell me who my new left child is."
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            // "Hey right child, delete the key and tell me who my new right child is."
            root.right = deleteNode(root.right, key);
        } else {
            // 2. We FOUND the node to delete (root.val == key)

            // Case A & B: Zero or One Child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Case C: Two Children
            // Step 1: Find the Inorder Successor (Smallest in the right subtree)
            root.val = findMin(root.right);

            // Step 2: Delete the old Successor node from the right subtree
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    // Helper to find the smallest value in a BST (always the furthest left)
    private int findMin(TreeNode node) {
        int min = node.val;
        while (node.left != null) {
            node = node.left;
            min = node.val;
        }
        return min;
    }
}