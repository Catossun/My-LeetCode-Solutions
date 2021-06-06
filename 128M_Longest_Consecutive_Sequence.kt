/**
 * Medium 128. Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * 
 * 616 ms, 58 MB
 */
class Solution {
    fun longestConsecutive(nums: IntArray): Int {   
        if(nums.size == 0) return 0
        
        var maxLength = 1
        val disNums = nums.distinct().toTypedArray()
        disNums.sort()
        var length = 1
        for(i in 0 until disNums.size - 1) {
            if(disNums[i] + 1 == disNums[i+1]) {
                ++length
                if(length > maxLength) maxLength = length
            } else {
                length = 1
            }
        }
        return maxLength
    }
}
