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
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;

        if(root.left == null && root.right == null)
            return 1;

        return countMethod(root);
    }

    public int countMethod(TreeNode node){

        if(node == null)
            return 0;
        if(node.left == null && node.right == null)
            return 1;

        int count = 0;
        count += countMethod(node.left);
        count += countMethod(node.right)+1;

        return count;
    }
}
