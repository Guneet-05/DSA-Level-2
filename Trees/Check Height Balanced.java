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
    
    static class Pair {
        boolean isBalanced = true;
        int height = 0;
    }
    
    public Pair isBalancedHelper(TreeNode root) {
        if(root == null) return new Pair();
        
        Pair left = isBalancedHelper(root.left);
        Pair right = isBalancedHelper(root.right);
        
        Pair curr = new Pair();
        curr.height = Math.max(left.height,right.height) + 1;
        curr.isBalanced = (left.isBalanced && right.isBalanced && Math.abs(left.height-right.height) <= 1);
        return curr;
    }
    
    public boolean isBalanced(TreeNode root) {
       return isBalancedHelper(root).isBalanced;
    }
}
