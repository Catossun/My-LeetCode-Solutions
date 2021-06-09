/**
 * Easy 1523. Count Odd Numbers in an Interval Range
 * https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
 *
 * 208 ms, 33.1 MB
 */
class Solution {
    fun countOdds(low: Int, high: Int): Int {
        return if(low.isOdd() || high.isOdd()) {
            (high - low) / 2 + 1
        } else {
            (high - low) / 2
        }
    }
    
    fun Int.isOdd(): Boolean = this % 2 == 1
}
