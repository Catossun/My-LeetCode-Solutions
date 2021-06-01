/**
 * Medium 1038. Binary Search Tree to Greater Sum Tree
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 *
 * 248 ms, 34.3 MB
 *
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    var sum = 0
    
    fun bstToGst(root: TreeNode?): TreeNode? {
        if(root == null) return root
        
        if(root.left == null && root.right == null) {
            if(sum == 0) {
                sum = root.`val`
            } else {
                sum += root.`val`
                root.`val` = sum
            }
            return root
        }
        
        bstToGst(root.right)
        sum += root.`val`
        root.`val` = sum
        
        bstToGst(root.left)
        
        return root
    }
}
