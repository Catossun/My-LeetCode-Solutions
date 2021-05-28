/**
 * Easy 485. Max Consecutive Ones
 * https://leetcode.com/problems/max-consecutive-ones/
 */
class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var max = 0
        var cur = 0
        nums.forEach{
            if(it == 0){
                cur = 0
            }else{
                ++cur
                max = Math.max(max, cur)
            }
        }
        return max
    }
}
