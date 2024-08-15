/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
			return null;
        return recMethod(nums,0,nums.length-1);
    }
    
    public TreeNode recMethod(int nums[],int start,int end){
        if(start>end){
            return null;
        }
        
        int mid=(start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left=recMethod(nums,start,mid-1);
        root.right=recMethod(nums,mid+1,end);
        
        return root;
    }
    
}
