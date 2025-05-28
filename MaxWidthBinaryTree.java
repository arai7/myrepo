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

class Pairs{
    TreeNode node;
    int index;

    Pairs(TreeNode node, int index){
        this.node = node;
        this.index = index;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        Queue<Pairs> q = new LinkedList<>();
        Pairs rootPair = new Pairs(root, 1);
        //rootPair.node = root;
        //rootPair.index = 1;
        q.add(rootPair);
        int maxWidth = -1;

        while(!q.isEmpty()){
            int size = q.size();
            int minIndex = q.peek().index;
            int first = 0;
            int last = 0;

            for(int i = 0; i < size; i++){
                Pairs curr = q.poll();
                TreeNode node = curr.node;
                int currIdx = curr.index - minIndex;

                if(i == 0){
                    first = currIdx;
                }
                if(i == size-1){
                    last = currIdx;
                }

                if(node.left != null){
                    q.offer(new Pairs(node.left, 2 * currIdx));
                }
                if(node.right != null){
                    q.offer(new Pairs(node.right, 2 * currIdx + 1));
                }
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }
        return maxWidth;
    }
}
