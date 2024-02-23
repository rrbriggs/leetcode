// 226. Invert Binary Tree
// Given the root of a binary tree, invert the tree, and return its root.

 

// Example 1:


// Input: root = [4,2,7,1,3,6,9]
// Output: [4,7,2,9,6,3,1]
// Example 2:


// Input: root = [2,1,3]
// Output: [2,3,1]
// Example 3:

// Input: root = []
// Output: []

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
    public TreeNode invertTree(TreeNode root) {
        // gonna recursive this bad boi
        //need a boop out 
        if (root == null) return root;
        
        // time to keep traversing through doin the swapperooo
        invertTree(root.left);

        invertTree(root.right);

        // here's the super basic magic
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }
}
