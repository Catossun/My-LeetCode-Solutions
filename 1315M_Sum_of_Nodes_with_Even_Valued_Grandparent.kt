/**
 * Medium 1315. Sum of Nodes with Even-Valued Grandparent
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
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
    fun sumEvenGrandparent(root: TreeNode?): Int {
        if(root == null) return 0
        if(root.left == null && root.right == null) return 0
        
        var sum = if(root.`val` % 2 == 0) {
            val leftSum = sumChildren(root.left, 0)
            val rightSum = sumChildren(root.right, 0)
            leftSum + rightSum
        } else {
            0
        }
        
        val leftSum = sumEvenGrandparent(root.left)
        val rightSum = sumEvenGrandparent(root.right)
        
        return sum + leftSum + rightSum
    }
    
    fun sumChildren(root: TreeNode?, curLevel: Int): Int {
        if(root == null) return 0
        if(curLevel == 1) return root.`val`
        
        val leftSum = sumChildren(root.left, curLevel + 1)
        val rightSum = sumChildren(root.right, curLevel + 1)
        
        return leftSum + rightSum
    }
}
