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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if(p!=null && q!= null && p.val != q.val){
            return false;
        }

        if((p == null && q!=null) ||(p != null && q==null) ){
            return false;
        }

        if(p == null && q==null){
            return true;
        }

        Boolean flagLeft=false;
        Boolean flagRight=false;
        if(p.val == q.val){
            flagLeft = isSameTree(p.left, q.left);
            flagRight = isSameTree(p.right, q.right);
        }
        return (flagLeft && flagRight);

    }
}
