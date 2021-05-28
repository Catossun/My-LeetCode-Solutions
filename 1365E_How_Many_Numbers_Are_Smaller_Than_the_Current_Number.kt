/**
 * Easy 1365. How Many Numbers Are Smaller Than the Current Number
 * https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 */
class Solution {
    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
    for((index, num) in nums.withIndex()){
        var count = 0
        for(i in 0 until nums.size){
            if(i == index) continue
            if(nums[i] < nums[index]){
                result.set(index, ++count)
            }
        }
    }
    
    return result
    }
}
