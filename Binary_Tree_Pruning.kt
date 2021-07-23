/**
 * Binary Tree Pruning
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/611/week-4-july-22nd-july-28th/3824/
 *
 * 136 ms 33.9 MB
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
    fun pruneTree(root: TreeNode?): TreeNode? {
        val hasOne = walk(root)
        return if(hasOne) root else null
    }
    
    fun walk(root: TreeNode?): Boolean {
        if(root == null) return false
        
        if(root.left == null && root.right == null) {
            return root.`val` == 1    
        }
        
        val hasOneAtLeft = walk(root.left)        
        if(!hasOneAtLeft) root.left = null
        
        val hasOneAtRight = walk(root.right)
        if(!hasOneAtRight) root.right = null
        
        return hasOneAtLeft || hasOneAtRight || root.`val` == 1
    }
}
