/**
 * Easy 1480. Running Sum of 1d Array
 * https://leetcode.com/problems/running-sum-of-1d-array/
 */
class Solution {
    fun runningSum(nums: IntArray): IntArray {
        val results = IntArray(nums.size)
        nums.forEachIndexed{index, num->
            var sum = 0
            for(i in 0..index){
                sum += nums[i]
            }
            results[index] = sum
        }
        return results
    }
}
