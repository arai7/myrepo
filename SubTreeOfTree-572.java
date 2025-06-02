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
class Solution 
{
    public boolean isSubtree(TreeNode root, TreeNode subRoot) 
    {
        if (root == null) 
            return false;
        
        // Check if the current root matches the subRoot
        if (isSameTree(root, subRoot)) 
            return true;

        // Check in the left and right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) 
    {
        if (p == null || q == null) 
            return p == q; // Both must be null to return true

        if (p.val != q.val) 
            return false; // Values are not the same

        // Recursively check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
