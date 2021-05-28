/**
 * Medium 1302. Deepest Leaves Sum
 * https://leetcode.com/problems/deepest-leaves-sum/
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
    fun deepestLeavesSum(root: TreeNode?): Int {
        val deepestLevel = findDeepestLevel(root, 0)
        val deepestSum = sum(root, 0, deepestLevel)
        return deepestSum
    }
    
    fun findDeepestLevel(root: TreeNode?, curLevel: Int): Int {
        if (root == null) return 0
        if (root.left == null && root.right == null) return curLevel
        
        val leftDeepestLevel = findDeepestLevel(root.left, curLevel + 1)
        val rightDeepestLevel = findDeepestLevel(root.right, curLevel + 1)
        
        return Math.max(leftDeepestLevel, rightDeepestLevel)
    }
    
    fun sum(root: TreeNode?, curLevel: Int, deepestLevel: Int): Int {
        if (root == null) return 0
        if (root.left == null && root.right == null && curLevel == deepestLevel) return root.`val`
        
        val leftSum = sum(root.left, curLevel + 1, deepestLevel)
        val rightSum = sum(root.right, curLevel + 1, deepestLevel)
        
        return leftSum + rightSum
    }
}
