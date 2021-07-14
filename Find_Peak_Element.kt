/*
 * Find Peak Element
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/609/week-2-july-8th-july-14th/3812/
 * 
 * 172 ms 36.4 MB
 */
class Solution {
    fun findPeakElement(nums: IntArray): Int {
        if(nums.size == 1) return 0
        if(nums.size == 2) return if(nums[0] > nums[1]) 0 else 1
        
        var prevNum = 0
        var nextNum = 0
        
        for(i in 0..nums.size) {
            prevNum = if(i - 1 < 0) 0 else nums[i - 1]
            nextNum = if(i + 1 == nums.size) 0 else nums[i + 1]
            if(nums[i] > prevNum && nums[i] > nextNum) {
                return i
            }
        }
        
        return 0
    }
}
