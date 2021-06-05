/**
 * Easy 1550. Three Consecutive Odds
 * https://leetcode.com/problems/three-consecutive-odds/
 *
 * 220 ms, 36.1 MB
 */
 class Solution {
    fun threeConsecutiveOdds(arr: IntArray): Boolean {
        var oddCount = 0
        arr.forEach {
            if(it % 2 == 0) {
                oddCount = 0
            } else {
                ++oddCount
                if(oddCount == 3) return true
            }
        }
        return false
    }
}
