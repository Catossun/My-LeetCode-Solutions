/**
 * Easy 938. Range Sum of BST
 * https://leetcode.com/problems/range-sum-of-bst/
 *
 * 320 ms, 44.4 MB
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
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        if(root == null) return 0
        
        val leftSum = if(root.`val` > low) rangeSumBST(root.left, low, high) else 0
        val rightSum = if(root.`val` < high) rangeSumBST(root.right, low, high) else 0
        val rootSum = if(root.`val` in low..high) root.`val` else 0
        
        return rootSum + leftSum + rightSum
    }
}
