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
        List<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }

        int height = calculate_height(root);
        //System.out.println("Height is "+height);

        for(int i = 1; i <= height; i++){
            //innerList1 = new ArrayList<>();
            res.add(printRight(root, i));
        }
        return res;
    }

    public int calculate_height(TreeNode node){
        if(node == null){
            return 0;
        }
        int left_height = 1;
        int right_height = 1;

        left_height += calculate_height(node.left);
        right_height += calculate_height(node.right);

        return Math.max(left_height, right_height);
    }

    public int printRight(TreeNode node, int height){
        int r_num = 101;
        if(node == null){
            return 101;
        }
        if(height == 1){
            return node.val;
        }
        else{
            r_num = printRight(node.right, height-1);
            if(r_num == 101){
                r_num = printRight(node.left, height-1);
            }
        }
        return r_num;
    }

}
