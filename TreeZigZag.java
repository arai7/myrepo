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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> listOfLists = new ArrayList<>();
        List<Integer> innerList1 = new ArrayList<>();
        if(root == null){
            return listOfLists;
        }

        int height = calculate_height(root);
        boolean flag = false;

        for(int i = 1; i <= height; i++){
            innerList1 = new ArrayList<>();
            getLevelElements(root, i, innerList1, flag);
            listOfLists.add(innerList1);
            if(flag)
                flag = false;
            else
                flag = true;
        }

        return listOfLists;
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

    public void getLevelElements(TreeNode node, int height, List<Integer> level_list, boolean flag){
        if(node == null){
            return;
        }
        if(height == 1){
            level_list.add(node.val);
        }
        else{
            if(flag){
                getLevelElements(node.right, height-1, level_list, flag);
                getLevelElements(node.left, height-1, level_list, flag);
            }
            else{
                getLevelElements(node.left, height-1, level_list, flag);
                getLevelElements(node.right, height-1, level_list, flag);
            }
        }
    }
}
