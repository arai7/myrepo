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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }

        if(root.left == null && root.right == null){
            if(root.val == targetSum)
                return true;
            return false;
        }
        
        return pathSum(root, 0, targetSum);
    }

    public boolean pathSum(TreeNode node, int sumSoFar, int targetSum){
        if(node == null){
            return false;
        }
        
        if(node.left == null && node.right == null){
            if(sumSoFar + node.val == targetSum){
                return true;
            }

            return false;
        }

        sumSoFar += node.val;
        boolean flag = pathSum(node.left, sumSoFar, targetSum);
        if(!flag)
            flag = pathSum(node.right, sumSoFar, targetSum);

        return flag;
    }
}
