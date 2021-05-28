/**
 * Easy 1281. Subtract the Product and Sum of Digits of an Integer
 * https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 */
class Solution {
    fun subtractProductAndSum(n: Int): Int {
        var nStrs = n.toString()
        var pro = 1
        var sum = 0
        nStrs.forEach{ c ->
            var n = c - '0'
            pro *= n.toInt()
            sum += n.toInt()
        }
        return pro - sum
    }
}