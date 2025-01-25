class Solution {
    public boolean isBalanced(TreeNode root) {
        return calHeight(root) != -1;
    }

    private int calHeight(TreeNode root) {
        if (root == null) {
            return 0; // Height of an empty subtree is 0
        }

        // Recursively calculate the height of the left and right subtrees
        int leftHeight = calHeight(root.left);
        if (leftHeight == -1) return -1; // Left subtree is unbalanced

        int rightHeight = calHeight(root.right);
        if (rightHeight == -1) return -1; // Right subtree is unbalanced

        // Check the balance condition at the current node
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Current subtree is unbalanced
        }

        // Return the height of the current subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
