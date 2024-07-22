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
    public int sumNumbers(TreeNode root) {
        
        int sum = helper(root, 0);
        return sum;
    }

    public int helper(TreeNode node, int pathSum){
        if (node == null) {
            return 0;
        }

        pathSum = pathSum*10+node.val;
        
        if(node.left == null && node.right == null){
            //System.out.println("reached leaf "+node.val);
            //System.out.println("pathSum before is "+pathSum);
            return pathSum;
        }
       
        return helper(node.left, pathSum) + helper(node.right, pathSum);
    }
}
